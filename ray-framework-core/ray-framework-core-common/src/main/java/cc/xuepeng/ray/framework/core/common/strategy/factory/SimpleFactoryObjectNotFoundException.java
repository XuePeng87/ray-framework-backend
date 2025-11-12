package cc.xuepeng.ray.framework.core.common.strategy.factory;

import cc.xuepeng.ray.framework.core.common.exception.BaseException;

/**
 * 简单工厂无法根据类型找到要实例化的对象
 *
 * @author xuepeng
 */
public class SimpleFactoryObjectNotFoundException extends BaseException {

    /**
     * 构造函数
     */
    public SimpleFactoryObjectNotFoundException() {
    }

    /**
     * 构造函数
     *
     * @param msg 异常信息
     */
    public SimpleFactoryObjectNotFoundException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     *
     * @param cause 异常原因
     */
    public SimpleFactoryObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     *
     * @param msg   异常信息
     * @param cause 异常原因
     */
    public SimpleFactoryObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
