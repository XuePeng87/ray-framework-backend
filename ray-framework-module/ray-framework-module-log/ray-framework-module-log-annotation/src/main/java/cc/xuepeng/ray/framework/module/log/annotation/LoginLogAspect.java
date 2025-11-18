package cc.xuepeng.ray.framework.module.log.annotation;

import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cc.xuepeng.ray.framework.module.log.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.module.log.enums.SysAuthLogTypeDto;
import cc.xuepeng.ray.framework.module.log.util.UserAgentInfoUtil;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.auth.service.IdentificationService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 登录日志的切面类
 *
 * @author xuepeng
 */
@Slf4j
@Aspect
@Component
public class LoginLogAspect {

    /**
     * ThreadLocal中的Key
     */
    private static final String THREAD_LOCAL_KEY = "LoginLog";

    /**
     * 对注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.module.log.annotation.LoginLog)")
    private void operation() {
        // 对请求进行切面处理
    }

    /**
     * 方法执行前的处理
     *
     * @param joinPoint 连接点
     */
    @Before("operation()")
    public void doBefore(JoinPoint joinPoint) {
        // 获取本次请求的元数据
        final HttpServletRequest request = WebUtil.getHttpServletRequest();
        final SysAuthLogDto sysAuthLogDto = new SysAuthLogDto();
        UserAgentInfoUtil.setUserAgentInfo(sysAuthLogDto, request);
        sysAuthLogDto.setCreateTime(LocalDateTime.now());
        sysAuthLogDto.setLoginIp(WebUtil.getIPAddress(request));
        // 保存封装信息到ThreadLocal中
        ThreadLocalUtil.put(THREAD_LOCAL_KEY, sysAuthLogDto);
    }

    /**
     * 方法返回后的处理
     *
     * @param joinPoint 连接点
     * @param result    返回值
     */
    @AfterReturning(value = "operation()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        try {
            if (identificationService.isLogin()) {
                final SysAuthLogDto sysAuthLogDto = (SysAuthLogDto) ThreadLocalUtil.getAndRemove(THREAD_LOCAL_KEY);
                final CurrentUser currentUser = identificationService.getCurrentUser();
                sysAuthLogDto.setCreateUser(currentUser.getCode());
                sysAuthLogDto.setPhoneNumber(currentUser.getPhoneNumber());
                final Duration exeTime = Duration.between(sysAuthLogDto.getCreateTime(), LocalDateTime.now());
                sysAuthLogDto.setExeTime(exeTime.toMillis());
                sysAuthLogDto.setType(SysAuthLogTypeDto.LOGIN);
            }
        } catch (Exception e) {
            log.error("保存登录日志失败：{}", e.getMessage());
        } finally {
            ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
        }
    }

    /**
     * 方法异常后的处理
     *
     * @param joinPoint 连接点
     * @param throwable 异常
     */
    @AfterThrowing(pointcut = "operation()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        ThreadLocalUtil.remove(THREAD_LOCAL_KEY);
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

}
