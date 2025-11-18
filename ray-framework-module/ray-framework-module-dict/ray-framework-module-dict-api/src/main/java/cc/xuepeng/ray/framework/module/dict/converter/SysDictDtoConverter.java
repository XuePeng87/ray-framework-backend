package cc.xuepeng.ray.framework.module.dict.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.dict.request.SysDictRequest;
import cc.xuepeng.ray.framework.module.dict.response.SysDictResponse;
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
