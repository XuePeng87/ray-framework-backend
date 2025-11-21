package cc.xuepeng.ray.framework.sdk.disruptor.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * Disruptor复制消息失败的异常类
 *
 * @author xuepeng
 */
public class DisruptorCopyMessageException extends BaseException {

    /**
     * 构造函数
     */
    public DisruptorCopyMessageException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public DisruptorCopyMessageException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public DisruptorCopyMessageException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public DisruptorCopyMessageException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
