package cc.xuepeng.ray.framework.facade.system.log.converter;

import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.log.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.facade.system.log.response.SysAuthLogResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统登录登出日志数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysAuthLogDtoConverter
        extends DtoConverter<SysAuthLogRequest, SysAuthLogDto, SysAuthLogResponse> {
}
