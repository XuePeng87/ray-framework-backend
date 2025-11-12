package cc.xuepeng.ray.framework.module.log.annotation;

import java.lang.annotation.*;

/**
 * 登出日志注解
 *
 * @author xuepeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogoutLog {
}
