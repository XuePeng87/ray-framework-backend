package cc.xuepeng.ray.framework.module.log.service.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.module.log.repository.entity.SysOperateLogDetail;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统操作日志详情实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysOperateLogDetailEntityConverter
        extends EntityConverter<SysOperateLogDetailDto, SysOperateLogDetail> {

}
