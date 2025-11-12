package cc.xuepeng.ray.framework.core.web.security.file;

import java.lang.annotation.*;

/**
 * 文件校验器的注解
 * 使用在方法上，表示启用验证器，会触发切面
 *
 * @author xuepeng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FileValidated {
}
