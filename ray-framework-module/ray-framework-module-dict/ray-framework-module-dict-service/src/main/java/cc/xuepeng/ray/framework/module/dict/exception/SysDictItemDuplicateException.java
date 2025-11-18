package cc.xuepeng.ray.framework.module.dict.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统字典项已存在的异常类
 *
 * @author xuepeng
 */
public class SysDictItemDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysDictItemDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysDictItemDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysDictItemDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysDictItemDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
