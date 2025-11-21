package cc.xuepeng.ray.framework.facade.system.role.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.role.request.SysRoleRequest;
import cc.xuepeng.ray.framework.facade.system.role.response.SysRoleResponse;
import cc.xuepeng.ray.framework.module.role.dto.SysRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统角色数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysRoleDtoConverter
        extends DtoConverter<SysRoleRequest, SysRoleDto, SysRoleResponse> {

}
