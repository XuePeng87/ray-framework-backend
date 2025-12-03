package cc.xuepeng.ray.framework.core.mybatis.annotation;

import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.TenantPlusConst;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 忽略租户插件注解的切面类
 *
 * @author xuepeng
 */
@Component
@Aspect
@Slf4j
public class IgnoreTenantAspect {

    /**
     * 对注解修饰的方法进行切面处理
     */
    @Pointcut(value = "@annotation(cc.xuepeng.ray.framework.core.mybatis.plus.tenant.IgnoreTenant)")
    private void ignoreTenant() {
        // 对请求进行切面处理
    }

    @Around("ignoreTenant()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            ThreadLocalUtil.put(TenantPlusConst.THREAD_LOCAL_KEY, Boolean.TRUE);
            result = joinPoint.proceed();
        } finally {
            ThreadLocalUtil.remove(TenantPlusConst.THREAD_LOCAL_KEY);
        }
        return result;
    }

}
