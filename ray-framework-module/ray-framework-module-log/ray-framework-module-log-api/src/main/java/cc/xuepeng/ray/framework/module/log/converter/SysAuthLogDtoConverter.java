package cc.xuepeng.ray.framework.module.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.log.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.module.log.response.SysAuthLogResponse;
import cc.xuepeng.ray.framework.module.log.dto.SysAuthLogDto;
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
