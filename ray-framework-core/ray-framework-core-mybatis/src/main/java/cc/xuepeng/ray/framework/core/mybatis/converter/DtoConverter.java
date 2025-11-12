package cc.xuepeng.ray.framework.core.mybatis.converter;

import cc.xuepeng.ray.framework.core.common.converter.BaseDtoConverter;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * Request、Dto、Response的转换器接口
 *
 * @param <P> 请求对象（Request）的类型
 * @param <D> 数据传输对象（Dto）的类型
 * @param <V> 响应对象（Response）的类型
 */
public interface DtoConverter<P, D, V> extends BaseDtoConverter<P, D, V> {

    /**
     * 将数据传输对象分页转换为响应对象分页
     *
     * @param dtoPage 数据传输对象分页
     * @return 转换后的响应对象分页
     */
    PageResponse<V> dtoPageToResponsePage(final Page<D> dtoPage);

}