package cc.xuepeng.ray.framework.core.common.exception;

/**
 * 文件格式校验失败的异常类
 *
 * @author xuepeng
 */
public class FileUtilException extends BaseException {

    /**
     * 构造函数
     */
    public FileUtilException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public FileUtilException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public FileUtilException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public FileUtilException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
