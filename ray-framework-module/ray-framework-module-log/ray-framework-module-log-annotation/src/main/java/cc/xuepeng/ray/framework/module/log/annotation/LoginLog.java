package cc.xuepeng.ray.framework.module.log.annotation;

import java.lang.annotation.*;

/**
 * 登录日志注解
 *
 * @author xuepeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginLog {

}
