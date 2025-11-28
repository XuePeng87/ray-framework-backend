package cc.xuepeng.ray.framework.module.tenant.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统租户不存在的异常类
 *
 * @author xuepeng
 */
public class SysTenantNotFoundException extends BaseException {

    /**
     * 构造函数
     */
    public SysTenantNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysTenantNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysTenantNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysTenantNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
