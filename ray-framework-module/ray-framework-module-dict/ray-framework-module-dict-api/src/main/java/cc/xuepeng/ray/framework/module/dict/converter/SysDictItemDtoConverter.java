package cc.xuepeng.ray.framework.module.dict.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.DtoConverter;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.dict.request.SysDictItemRequest;
import cc.xuepeng.ray.framework.module.dict.response.SysDictItemResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * 系统字典项数据传输类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysDictItemDtoConverter
        extends DtoConverter<SysDictItemRequest, SysDictItemDto, SysDictItemResponse> {

}
