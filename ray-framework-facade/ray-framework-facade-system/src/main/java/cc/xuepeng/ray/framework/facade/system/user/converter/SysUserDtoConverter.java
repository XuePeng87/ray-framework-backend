package cc.xuepeng.ray.framework.facade.system.user.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.user.request.SysUserRequest;
import cc.xuepeng.ray.framework.facade.system.user.response.SysUserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ray.framework.module.user.dto.SysUserDto;

/**
 * 系统用户数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserDtoConverter
        extends DtoConverter<SysUserRequest, SysUserDto, SysUserResponse> {

}
