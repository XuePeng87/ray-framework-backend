package cc.xuepeng.ray.framework.module.dept.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.dept.entity.SysDept;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统部门实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDeptEntityConverter
        extends EntityConverter<SysDeptDto, SysDept> {
}
