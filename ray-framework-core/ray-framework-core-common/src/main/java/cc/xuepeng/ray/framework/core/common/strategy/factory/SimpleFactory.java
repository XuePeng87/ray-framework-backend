package cc.xuepeng.ray.framework.core.common.strategy.factory;

import java.util.List;
import java.util.Optional;

/**
 * 简单工厂的父类
 *
 * @param <T> 工厂生产的对象类型
 * @param <E> 对象类型枚举
 * @author xuepeng
 */
public interface SimpleFactory<T extends SimpleFactoryObject<E>, E> {

    /**
     * 根据类型获取对象实例
     *
     * @param type 对象类型枚举
     * @return 对象实例
     */
    default T getInstance(final E type) {
        final Optional<T> objects = getObjects().stream()
                .filter(s -> s.getType().equals(type))
                .findFirst();
        if (objects.isPresent()) {
            return objects.get();
        } else {
            throw new SimpleFactoryObjectNotFoundException("无法根据类型找到要实例化的对象");
        }
    }

    /**
     * @return 获取策略集合
     */
    List<T> getObjects();

}
