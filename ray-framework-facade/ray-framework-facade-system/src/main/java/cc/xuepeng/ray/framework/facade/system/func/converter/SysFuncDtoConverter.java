package cc.xuepeng.ray.framework.facade.system.func.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.func.request.SysFuncRequest;
import cc.xuepeng.ray.framework.facade.system.func.response.SysFuncResponse;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统功能数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysFuncDtoConverter
        extends DtoConverter<SysFuncRequest, SysFuncDto, SysFuncResponse> {

}
