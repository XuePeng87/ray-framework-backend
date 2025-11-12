package cc.xuepeng.ray.framework.sdk.auth.annotation;

import java.lang.annotation.*;

/**
 * 设置修改人
 *
 * @author xuepeng
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModifyUser {
}
