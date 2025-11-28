package cc.xuepeng.ray.framework.facade.system.tenent.converter;


import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.tenent.request.SysTenantRequest;
import cc.xuepeng.ray.framework.facade.system.tenent.response.SysTenantResponse;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统租户数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysTenantDtoConverter
        extends DtoConverter<SysTenantRequest, SysTenantDto, SysTenantResponse> {
}
