package cc.xuepeng.ray.framework.core.common.converter;

import java.util.List;

/**
 * Request、Dto、Response的转换器接口
 *
 * @param <P> 请求对象（Request）的类型
 * @param <D> 数据传输对象（Dto）的类型
 * @param <V> 响应对象（Response）的类型
 */
public interface BaseDtoConverter<P, D, V> {

    /**
     * 将请求对象转换为数据传输对象
     *
     * @param request 请求对象
     * @return 转换后的数据传输对象
     */
    D requestToDto(final P request);

    /**
     * 将数据传输对象转换为响应对象
     *
     * @param dto 数据传输对象
     * @return 转换后的响应对象
     */
    V dtoToResponse(final D dto);

    /**
     * 将请求对象列表转换为数据传输对象列表
     *
     * @param requestList 请求对象列表
     * @return 转换后的数据传输对象列表
     */
    List<D> requestListToDtoList(final List<P> requestList);

    /**
     * 将数据传输对象列表转换为响应对象列表
     *
     * @param dtoList 数据传输对象列表
     * @return 转换后的响应对象列表
     */
    List<V> dtoListToResponseList(final List<D> dtoList);

}