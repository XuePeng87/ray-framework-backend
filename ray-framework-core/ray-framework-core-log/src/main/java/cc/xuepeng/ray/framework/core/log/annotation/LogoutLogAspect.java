package cc.xuepeng.ray.framework.core.log.annotation;

import cc.xuepeng.ray.framework.core.auth.message.AsyncAuthMessage;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.log.disruptor.SysAuthLogDisruptorManager;
import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.log.enums.SysAuthLogType;
import cc.xuepeng.ray.framework.core.log.exception.CreateLogFailedException;
import cc.xuepeng.ray.framework.core.log.util.UserAgentInfoUtil;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 登出日志的切面类
 *
 * @author xuepeng
 */
@Slf4j
@Aspect
@Component
public class LogoutLogAspect {

    /**
     * 对注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.core.log.annotation.LogoutLog)")
    private void operation() {
        // 对请求进行切面处理
    }

    @Around("operation()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        // 获取本次请求的元数据
        final HttpServletRequest request = WebUtil.getHttpServletRequest();
        final SysAuthLogDto sysAuthLogDto = new SysAuthLogDto();
        Object result = null;
        // 获取本次请求的元数据
        UserAgentInfoUtil.setUserAgentInfo(sysAuthLogDto, request);
        // 封装Request信息
        sysAuthLogDto.setCreateTime(LocalDateTime.now());
        sysAuthLogDto.setLoginIp(WebUtil.getIPAddress(request));
        // 执行目标方法
        try {
            sysAuthLogDto.setLoginIp(WebUtil.getIPAddress(request));
            if (identificationService.isLogin()) {
                final CurrentUser currentUser = identificationService.getCurrentUser();
                sysAuthLogDto.setCreateUser(currentUser.getCode());
                sysAuthLogDto.setPhoneNumber(currentUser.getPhoneNumber());
            }
            result = joinPoint.proceed();
            final Duration exeTime = Duration.between(sysAuthLogDto.getCreateTime(), LocalDateTime.now());
            sysAuthLogDto.setExeTime(exeTime.toMillis());
            sysAuthLogDto.setType(SysAuthLogType.LOGOUT);
            // 发送登录日志到Disruptor
            log.info("LogoutLogAspect -> {}", sysAuthLogDto);
            final AsyncAuthMessage<SysAuthLogDto> message = new AsyncAuthMessage<>(
                    identificationService.getToken(),
                    sysAuthLogDto
            );
            sysAuthLogDisruptorManager.publish(message);
        } catch (Throwable throwable) {
            log.error("LoginLogAspect -> 登录日志切面处理异常: ", throwable);
            throw new CreateLogFailedException(throwable);
        }
        return result;
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

    /**
     * 系统登录认证日志Disruptor管理器
     */
    @Resource
    private SysAuthLogDisruptorManager sysAuthLogDisruptorManager;

}
