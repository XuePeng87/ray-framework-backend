package cc.xuepeng.ray.framework.facade.system.log.converter;

import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.log.request.SysOperateLogDetailRequest;
import cc.xuepeng.ray.framework.facade.system.log.response.SysOperateLogDetailResponse;
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