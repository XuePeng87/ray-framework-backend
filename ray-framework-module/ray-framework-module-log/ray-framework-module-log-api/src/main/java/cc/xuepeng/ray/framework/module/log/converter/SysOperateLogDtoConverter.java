package cc.xuepeng.ray.framework.module.log.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.log.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.module.log.response.SysOperateLogResponse;
import cc.xuepeng.ray.framework.module.log.dto.SysOperateLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统操作日志数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperateLogDtoConverter
        extends DtoConverter<SysOperateLogRequest, SysOperateLogDto, SysOperateLogResponse> {
}