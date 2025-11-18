package cc.xuepeng.ray.framework.module.dict.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.dict.entity.SysDictItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统字典项实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictItemEntityConverter
        extends EntityConverter<SysDictItemDto, SysDictItem> {

}
