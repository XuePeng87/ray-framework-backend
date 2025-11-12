package cc.xuepeng.ray.framework.core.web.security.file;

import cc.xuepeng.ray.framework.core.common.enums.FileType;

import java.lang.annotation.*;

/**
 * 文件校验的注解
 *
 * @author xuepeng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Documented
public @interface FileValidator {

    /**
     * @return 要校验的文件类型
     */
    FileType[] types() default {};

    /**
     * @return 要校验的文件大小，单位是M
     */
    int size() default 1;

}
