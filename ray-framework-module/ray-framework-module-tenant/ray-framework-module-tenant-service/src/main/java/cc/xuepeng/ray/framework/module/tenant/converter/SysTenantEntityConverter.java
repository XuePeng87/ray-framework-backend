package cc.xuepeng.ray.framework.module.tenant.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import cc.xuepeng.ray.framework.module.tenant.entity.SysTenant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统租户实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysTenantEntityConverter
        extends EntityConverter<SysTenantDto, SysTenant> {

}
