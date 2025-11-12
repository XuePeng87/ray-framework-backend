package cc.xuepeng.ray.framework.module.log.annotation;

import cc.xuepeng.ray.framework.module.log.enums.SysOperateLogAction;

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
     * @return 是否持久化
     */
    boolean persistent() default true;

}
