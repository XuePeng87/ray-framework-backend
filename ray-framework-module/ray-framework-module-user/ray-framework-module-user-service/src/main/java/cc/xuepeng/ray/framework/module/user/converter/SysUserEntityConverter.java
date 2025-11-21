package cc.xuepeng.ray.framework.module.user.converter;

import cc.xuepeng.ray.framework.core.mybatis.converter.EntityConverter;
import cc.xuepeng.ray.framework.module.user.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ray.framework.module.user.dto.SysUserDto;

/**
 * 系统用户实体类转换接口
 *
 * @author xuepeng
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysUserEntityConverter
        extends EntityConverter<SysUserDto, SysUser> {

}
