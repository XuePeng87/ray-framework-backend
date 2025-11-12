package cc.xuepeng.ray.framework.core.rocketmq.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * RocketMQ发送失败异常
 *
 * @author xuepeng
 */
public class RocketMQSendFailedException extends BaseException {

    /**
     * 构造函数
     */
    public RocketMQSendFailedException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public RocketMQSendFailedException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public RocketMQSendFailedException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public RocketMQSendFailedException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
