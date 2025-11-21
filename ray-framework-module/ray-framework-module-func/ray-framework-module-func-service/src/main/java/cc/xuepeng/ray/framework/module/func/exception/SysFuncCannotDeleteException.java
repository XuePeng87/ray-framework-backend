package cc.xuepeng.ray.framework.module.func.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统功能不能删除的异常类
 *
 * @author xuepeng
 */
public class SysFuncCannotDeleteException extends BaseException {

    /**
     * 构造函数
     */
    public SysFuncCannotDeleteException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysFuncCannotDeleteException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysFuncCannotDeleteException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysFuncCannotDeleteException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
