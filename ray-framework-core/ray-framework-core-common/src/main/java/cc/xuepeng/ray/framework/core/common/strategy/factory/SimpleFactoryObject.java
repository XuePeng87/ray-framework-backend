package cc.xuepeng.ray.framework.core.common.strategy.factory;

/**
 * 简单工厂要创建的对象接口
 *
 * @param <E> 对象类型枚举
 * @author xuepeng
 */
public interface SimpleFactoryObject<E> {

    /**
     * @return 对象类型枚举
     */
    E getType();

}
