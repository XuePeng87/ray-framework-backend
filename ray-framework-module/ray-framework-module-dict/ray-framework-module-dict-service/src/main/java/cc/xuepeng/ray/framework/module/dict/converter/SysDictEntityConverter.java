package cc.xuepeng.ray.framework.module.dict.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.dict.entity.SysDict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统字典实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictEntityConverter
        extends EntityConverter<SysDictDto, SysDict> {
}
