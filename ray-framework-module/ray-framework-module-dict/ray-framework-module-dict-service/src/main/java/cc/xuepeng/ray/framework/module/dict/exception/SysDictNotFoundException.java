package cc.xuepeng.ray.framework.module.dict.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统字典不存在的异常类
 *
 * @author xuepeng
 */
public class SysDictNotFoundException extends BaseException {

    /**
     * 构造函数
     */
    public SysDictNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysDictNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysDictNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysDictNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
