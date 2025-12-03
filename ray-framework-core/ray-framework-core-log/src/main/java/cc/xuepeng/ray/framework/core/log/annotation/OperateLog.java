package cc.xuepeng.ray.framework.core.log.annotation;

import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;

import java.lang.annotation.*;

/**
 * 系统操作日志的注解
 *
 * @author xuepeng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperateLog {

    /**
     * @return 模块
     */
    String module();

    /**
     * @return 功能
     */
    String func();

    /**
     * @return 描述
     */
    String remark();

    /**
     * @return 动作
     */
    SysOperateLogAction action();

    /**
     * @return 是否持久化请求参数
     */
    boolean ignoreResponse() default false;

}
