package cc.xuepeng.ray.framework.core.web.security.file;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 文件校验不通过的异常类
 *
 * @author xuepeng
 */
public class FileValidatorException extends BaseException {

    /**
     * 构造函数
     */
    public FileValidatorException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public FileValidatorException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public FileValidatorException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public FileValidatorException(String msg, Throwable cause) {
        super(msg, cause);
    }

}