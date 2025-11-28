package cc.xuepeng.ray.framework.core.auth.annotation;

import java.lang.annotation.*;

/**
 * 异步认证处理注解
 * 用户跨线程的身份认证处理
 * 主要解决SaToken在异步线程中无法使用Web上下文的问题
 *
 * @author xuepeng
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AsyncAuthHandler {
}
