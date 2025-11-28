package cc.xuepeng.ray.framework.core.mybatis.plus.tenant;

import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        ThreadLocalUtil.put(MyBatisTenantPlusConst.THREAD_LOCAL_KEY, Boolean.TRUE);
    }

    /**
     * 方法返回后的处理
     *
     * @param joinPoint 连接点
     * @param result    返回值
     */
    @AfterReturning(value = "operation()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result) {
        ThreadLocalUtil.remove(MyBatisTenantPlusConst.THREAD_LOCAL_KEY);
    }

    /**
     * 方法异常后的处理
     *
     * @param joinPoint 连接点
     * @param throwable 异常
     */
    @AfterThrowing(pointcut = "operation()", throwing = "throwable")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        ThreadLocalUtil.remove(MyBatisTenantPlusConst.THREAD_LOCAL_KEY);
    }

}
