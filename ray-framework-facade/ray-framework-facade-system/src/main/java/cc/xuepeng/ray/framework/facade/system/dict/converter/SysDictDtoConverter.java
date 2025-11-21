package cc.xuepeng.ray.framework.facade.system.dict.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.facade.system.dict.request.SysDictRequest;
import cc.xuepeng.ray.framework.facade.system.dict.response.SysDictResponse;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统字典数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictDtoConverter
        extends DtoConverter<SysDictRequest, SysDictDto, SysDictResponse> {
}
