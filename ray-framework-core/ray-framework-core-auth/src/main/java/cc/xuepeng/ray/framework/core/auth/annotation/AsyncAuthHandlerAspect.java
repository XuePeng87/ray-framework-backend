package cc.xuepeng.ray.framework.core.auth.annotation;

import cc.xuepeng.ray.framework.core.auth.message.AsyncAuthMessage;
import cn.dev33.satoken.context.mock.SaTokenContextMockUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 异步认证处理的切面类
 *
 * @author xuepeng
 */
@Aspect
@Component
public class AsyncAuthHandlerAspect {

    /**
     * 处理异步认证
     */
    @Pointcut("@annotation(cc.xuepeng.ray.framework.core.auth.annotation.AsyncAuthHandler)")
    private void asyncAuthHandler() {
        // 处理异步认证
    }

    /**
     * 设置SaToken的上下文
     *
     * @param joinPoint 连接点
     */
    @Around("asyncAuthHandler()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            for (final Object arg : joinPoint.getArgs()) {
                if (arg instanceof AsyncAuthMessage<?> message) {
                    SaTokenContextMockUtil.setMockContext();
                    StpUtil.setTokenValueToStorage(message.getToken());
                }
            }
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        } finally {
            SaTokenContextMockUtil.clearContext();
        }
        return result;
    }

}
