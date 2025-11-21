package cc.xuepeng.ray.framework.module.role.exception;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 系统角色已存在的异常类
 *
 * @author xuepeng
 */
public class SysRoleDuplicateException extends BaseException {

    /**
     * 构造函数
     */
    public SysRoleDuplicateException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SysRoleDuplicateException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SysRoleDuplicateException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SysRoleDuplicateException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
