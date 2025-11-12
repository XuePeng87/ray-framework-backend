package cc.xuepeng.ray.framework.sdk.auth.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 未登录的异常类
 *
 * @author xuepeng
 */
public class SessionUserNotFoundException extends BaseException {

    /**
     * 构造函数
     */
    public SessionUserNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SessionUserNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SessionUserNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SessionUserNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
