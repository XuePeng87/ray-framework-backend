package cc.xuepeng.ray.framework.module.auth.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 登录系统锁定的异常类
 *
 * @author xuepeng
 */
public class SysLoginLockedException extends BaseException {

    /**
     * 构造函数
     */
    public SysLoginLockedException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysLoginLockedException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysLoginLockedException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysLoginLockedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
