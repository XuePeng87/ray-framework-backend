package cc.xuepeng.ray.framework.module.dept.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统部门已存在的异常类
 *
 * @author xuepeng
 */
public class SysDeptDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysDeptDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysDeptDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysDeptDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysDeptDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
