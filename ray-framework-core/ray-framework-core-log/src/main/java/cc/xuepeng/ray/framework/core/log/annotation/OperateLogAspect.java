package cc.xuepeng.ray.framework.core.log.annotation;

import cc.xuepeng.ray.framework.core.auth.message.AsyncAuthMessage;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.common.consts.PunctuationConst;
import cc.xuepeng.ray.framework.core.log.disruptor.SysOperateLogDisruptorManager;
import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogType;
import cc.xuepeng.ray.framework.core.log.util.UserAgentInfoUtil;
import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * 系统操作日志的切面类
 *
 * @author xuepeng
 */
@Slf4j
@Aspect
@Component
public class OperateLogAspect {

    /**
     * 对被系统操作日志注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.core.log.annotation.OperateLog)")
    private void operation() {
        // 对请求进行切面处理
    }

    @Around("operation()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        final HttpServletRequest request = WebUtil.getHttpServletRequest();
        final Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        final SysOperateLogDto sysOperateLogDto = new SysOperateLogDto();
        final LocalDateTime startTime = LocalDateTime.now();
        Object result = null;
        try {
            // 获取本次请求的元数据
            UserAgentInfoUtil.setUserAgentInfo(sysOperateLogDto, request);
            // 封装Request信息
            setRequestInfo(sysOperateLogDto, request, joinPoint);
            // 封装注解信息
            setAnnotationInfo(sysOperateLogDto, method.getAnnotation(OperateLog.class));
            // 设置认证信息
            setAuthInfo(sysOperateLogDto);
            result = joinPoint.proceed();
            return result;
        } catch (Throwable e) {
            sysOperateLogDto.getDetail().setError(e.getMessage());
            sysOperateLogDto.setType(SysOperateLogType.ERROR);
            throw e;
        } finally {
            if (result != null) {
                sysOperateLogDto.getDetail().setResult(result.toString());
            }
            sysOperateLogDto.setExeTime(exeTime(startTime));
            sysOperateLogDto.setType(SysOperateLogType.ACCESS);
            log.info("OperateLogAspect -> {}", sysOperateLogDto);
            sysOperateLogDisruptorManager.publish(sysOperateLogDto);
        }
    }

    /**
     * 设置系统操作日志的认证信息
     *
     * @param sysOperateLogDto 系统操作日志数的据传输对象
     */
    private void setAuthInfo(final SysOperateLogDto sysOperateLogDto) {
        // 设置用户信息
        if (identificationService.isLogin()) {
            final CurrentUser currentUser = identificationService.getCurrentUser();
            sysOperateLogDto.setTenantCode(currentUser.getTenantCode());
            sysOperateLogDto.setCreateUser(currentUser.getCode());
            sysOperateLogDto.setPhoneNumber(currentUser.getPhoneNumber());
        } else {
            sysOperateLogDto.setTenantCode(DEFAULT_TENANT_CODE);
            sysOperateLogDto.setCreateUser(DEFAULT_CREATE_USER);
        }
    }

    // TODO 放到配置中心
    private static final String DEFAULT_TENANT_CODE = "e79b0554909b4d43921e53d99f325842";
    private static final String DEFAULT_CREATE_USER = "5664b7f6cddb42aca28aedd07bb051a1";

    /**
     * 设置Request信息
     *
     * @param sysOperateLogDto 系统操作日志数的据传输对象
     * @param request          请求对象
     * @param joinPoint        连接点对象
     */
    private void setRequestInfo(final SysOperateLogDto sysOperateLogDto,
                                final HttpServletRequest request,
                                final JoinPoint joinPoint) {
        // 请求信息
        sysOperateLogDto.setCreateTime(LocalDateTime.now());
        sysOperateLogDto.setUrl(request.getRequestURL().toString());
        sysOperateLogDto.setUri(request.getRequestURI());
        sysOperateLogDto.setMethod(request.getMethod());
        sysOperateLogDto.setIp(WebUtil.getIPAddress(request));
        sysOperateLogDto.setClassName(joinPoint.getTarget().getClass().getName());
        // API Params信息
        final StringBuilder params = new StringBuilder();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> params
                .append(k)
                .append(PunctuationConst.EQUAL)
                .append(v[0])
                .append(PunctuationConst.SEMICOLON)
        );
        if (StringUtils.isNotBlank(params)) {
            sysOperateLogDto.getDetail().setParam(params.toString());
        }
        // API Args信息
        final StringBuilder args = new StringBuilder();
        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            args.append(PunctuationConst.LEFT_SQUARE_BRACKETS)
                    .append("arg")
                    .append(i)
                    .append(PunctuationConst.COLON)
                    .append(joinPoint.getArgs()[i])
                    .append(PunctuationConst.RIGHT_SQUARE_BRACKETS);
        }
        if (StringUtils.isNotBlank(args)) {
            sysOperateLogDto.getDetail().setArgs(args.toString());
        }
    }

    /**
     * 设置注解信息
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     * @param operateLog       系统操作日志注解
     */
    private void setAnnotationInfo(final SysOperateLogDto sysOperateLogDto, final OperateLog operateLog) {
        sysOperateLogDto.setModule(operateLog.module());
        sysOperateLogDto.setFunc(operateLog.func());
        sysOperateLogDto.setRemark(operateLog.remark());
        sysOperateLogDto.setAction(operateLog.action().name());
        sysOperateLogDto.setPersistent(operateLog.persistent());
    }

    /**
     * @return 计算请求执行时间
     */
    public long exeTime(final LocalDateTime startTime) {
        final Duration exeTime = Duration.between(startTime, LocalDateTime.now());
        return exeTime.toMillis();
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

    /**
     * 系统操作日志的Disruptor管理器
     */
    @Resource
    private SysOperateLogDisruptorManager sysOperateLogDisruptorManager;

}
