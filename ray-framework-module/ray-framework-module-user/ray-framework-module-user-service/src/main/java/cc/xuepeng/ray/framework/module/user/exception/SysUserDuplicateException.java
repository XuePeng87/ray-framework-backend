package cc.xuepeng.ray.framework.module.user.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统用户已存在的异常类
 *
 * @author xuepeng
 */
public class SysUserDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysUserDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysUserDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysUserDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysUserDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
