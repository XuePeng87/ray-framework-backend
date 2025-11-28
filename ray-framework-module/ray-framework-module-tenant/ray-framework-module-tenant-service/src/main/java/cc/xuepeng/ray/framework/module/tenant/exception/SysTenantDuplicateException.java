package cc.xuepeng.ray.framework.module.tenant.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统租户已存在的异常类
 *
 * @author xuepeng
 */
public class SysTenantDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysTenantDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysTenantDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysTenantDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysTenantDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
