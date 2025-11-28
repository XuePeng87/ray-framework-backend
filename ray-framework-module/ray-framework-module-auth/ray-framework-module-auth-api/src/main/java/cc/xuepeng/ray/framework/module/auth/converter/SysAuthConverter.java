package cc.xuepeng.ray.framework.module.auth.converter;

import cc.xuepeng.ray.framework.module.auth.dto.SysLoginDto;
import cc.xuepeng.ray.framework.module.auth.request.SysLoginRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统认证对象转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysAuthConverter {

    /**
     * Param转换Dto
     *
     * @param sysLoginRequest Param对象
     * @return Dto对象
     */
    SysLoginDto requestToDto(final SysLoginRequest sysLoginRequest);

}
