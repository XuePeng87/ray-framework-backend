package cc.xuepeng.ray.framework.core.common.converter;

import java.util.List;

/**
 * Dto与Entity的转换器接口
 *
 * @param <D> 数据传输对象（Dto）的类型
 * @param <E> 实体对象（Entity）的类型
 * @author xuepeng
 */
public interface BaseEntityConverter<D, E> {

    /**
     * 将数据传输对象转换为实体对象
     *
     * @param dto 数据传输对象
     * @return 转换后的实体对象
     */
    E dtoToEntity(final D dto);

    /**
     * 将实体对象转换为数据传输对象
     *
     * @param entity 实体对象
     * @return 转换后的数据传输对象
     */
    D entityToDto(final E entity);

    /**
     * 将数据传输对象列表转换为实体对象列表
     *
     * @param dtoList 数据传输对象列表
     * @return 转换后的实体对象列表
     */
    List<E> dtoListToEntityList(final List<D> dtoList);

    /**
     * 将实体对象列表转换为数据传输对象列表
     *
     * @param entityList 实体对象列表
     * @return 转换后的数据传输对象列表
     */
    List<D> entityListToDtoList(final List<E> entityList);

}