package cc.xuepeng.ray.framework.core.web.security.file;

import cc.xuepeng.ray.framework.core.common.consts.FileConst;
import cc.xuepeng.ray.framework.core.common.enums.FileType;
import cc.xuepeng.ray.framework.core.web.util.MultipartFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 文件校验器的切面类
 *
 * @author xuepeng
 */
@Component
@Slf4j
@Aspect
public class FileValidatorAspect {

    /**
     * 验证文件
     */
    @Pointcut("@annotation(cc.xuepeng.ray.framework.core.web.security.file.FileValidated)")
    private void validated() {
        // 验证文件
    }

    /**
     * 根据注解验证文件
     *
     * @param joinPoint 连接点
     */
    @Before("validated()")
    public void doBefore(final JoinPoint joinPoint)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg.getClass().isAnnotationPresent(FileValidator.class)) {
                // parameter注解验证
                validate(arg, arg.getClass().getAnnotation(FileValidator.class));
            } else {
                // field注解验证
                final Class<?> clazz = arg.getClass();
                final Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(FileValidator.class)) {
                        final String methodName = "get" + StringUtils.capitalize(field.getName());
                        final Method method = clazz.getMethod(methodName);
                        validate(method.invoke(arg), field.getAnnotation(FileValidator.class));
                    }
                }
            }
        }
    }

    /**
     * 文件验证
     *
     * @param arg        验证对象
     * @param annotation 验证注解
     */
    private void validate(final Object arg, final FileValidator annotation) {
        if (ObjectUtils.isEmpty(arg)) {
            throw new FileValidatorException("文件不能为空");
        }
        if (arg instanceof MultipartFile file) {
            validateSuffix(file, annotation.types());
            validateSize(file, annotation.size());
        } else if (arg instanceof MultipartFile[] files) {
            for (MultipartFile file : files) {
                validateSuffix(file, annotation.types());
                validateSize(file, annotation.size());
            }
        } else {
            log.warn("FileValidator注解只能使用于MultipartFile对象，无法使用于{}", arg.getClass().getName());
        }
    }

    /**
     * 文件后缀名验证
     *
     * @param file  验证文件
     * @param types 支持的后缀名
     */
    private void validateSuffix(final MultipartFile file, final FileType[] types) {
        if (!MultipartFileUtil.validate(file, types)) {
            throw new FileValidatorException("文件格式不正确");
        }
    }

    /**
     * 文件大小验证
     *
     * @param file 验证文件
     * @param size 支持的文件大小
     */
    private void validateSize(final MultipartFile file, final long size) {
        if (file.getSize() > size * FileConst.MB) {
            throw new FileValidatorException(String.format("文件大小不能大于%dM", size));
        }
    }

}
