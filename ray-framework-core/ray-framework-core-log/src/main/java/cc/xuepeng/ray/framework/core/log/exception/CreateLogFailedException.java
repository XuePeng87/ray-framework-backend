package cc.xuepeng.ray.framework.core.log.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 创建日志记录失败的异常类
 *
 * @author xuepeng
 */
public class CreateLogFailedException extends BaseException {

    /**
     * 构造函数
     */
    public CreateLogFailedException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public CreateLogFailedException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public CreateLogFailedException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public CreateLogFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
