package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 文件解析的异常类
 *
 * @author xuepeng
 */
public class FileParseException extends BaseException {

    /**
     * 构造函数
     */
    public FileParseException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public FileParseException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public FileParseException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public FileParseException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
