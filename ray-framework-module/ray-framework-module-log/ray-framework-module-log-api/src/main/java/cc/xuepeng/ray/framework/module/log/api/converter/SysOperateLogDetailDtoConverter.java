package cc.xuepeng.ray.framework.module.log.api.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.log.api.request.SysOperateLogDetailRequest;
import cc.xuepeng.ray.framework.module.log.api.response.SysOperateLogDetailResponse;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统操作日志详情数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperateLogDetailDtoConverter
        extends DtoConverter<SysOperateLogDetailRequest, SysOperateLogDetailDto, SysOperateLogDetailResponse> {
}