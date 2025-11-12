package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 文件转换的异常类
 *
 * @author xuepeng
 */
public class FileConvertException extends BaseException {

    /**
     * 构造函数
     */
    public FileConvertException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public FileConvertException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public FileConvertException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public FileConvertException(String msg, Throwable cause) {
        super(msg, cause);
    }

}