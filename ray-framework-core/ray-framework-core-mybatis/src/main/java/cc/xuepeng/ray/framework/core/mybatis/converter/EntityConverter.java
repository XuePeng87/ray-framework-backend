package cc.xuepeng.ray.framework.core.mybatis.converter;

import cc.xuepeng.ray.framework.core.common.converter.BaseEntityConverter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * Dto与Entity的转换器接口
 *
 * @param <D> 数据传输对象（Dto）的类型
 * @param <E> 实体对象（Entity）的类型
 */
public interface EntityConverter<D, E> extends BaseEntityConverter<D, E> {

    /**
     * 将实体对象分页转换为数据传输对象分页
     *
     * @param entityPage 实体对象分页
     * @return 转换后的数据传输对象分页
     */
    Page<D> entityPageToDtoPage(final Page<E> entityPage);

}