package cc.xuepeng.ray.framework.facade.system.log.converter;

import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.log.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.facade.system.log.response.SysOperateLogResponse;
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