package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 加解密的异常类
 *
 * @author xuepeng
 */
public class CodecException extends BaseException {

    /**
     * 构造函数
     */
    public CodecException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public CodecException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public CodecException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public CodecException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
