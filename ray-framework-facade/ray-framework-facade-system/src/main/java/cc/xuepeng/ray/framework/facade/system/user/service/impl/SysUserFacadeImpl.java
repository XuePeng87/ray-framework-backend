package cc.xuepeng.ray.framework.facade.system.user.service.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.user.converter.SysUserDtoConverter;
import cc.xuepeng.ray.framework.facade.system.user.request.SysUserRequest;
import cc.xuepeng.ray.framework.facade.system.user.response.SysUserResponse;
import cc.xuepeng.ray.framework.facade.system.user.service.SysUserFacade;
import cc.xuepeng.ray.framework.module.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import ray.framework.module.user.dto.SysUserDto;

/**
 * 系统功能的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysUserFacadeImpl implements SysUserFacade {

    /**
     * 创建系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否创建成功
     */
    public boolean create(final SysUserRequest sysUserRequest) {
        final SysUserDto sysUserDto = sysUserDtoConverter.requestToDto(sysUserRequest);
        return sysUserService.create(sysUserDto);
    }

    /**
     * 修改系统用户
     *
     * @param code         系统用户的编号
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否修改成功
     */
    public boolean update(final String code, final SysUserRequest sysUserRequest) {
        final SysUserDto sysUserDto = sysUserDtoConverter.requestToDto(sysUserRequest);
        sysUserDto.setCode(code);
        return sysUserService.update(sysUserDto);
    }

    /**
     * 删除系统用户
     *
     * @param code 系统用户的编号
     * @return 是否删除成功
     */
    public boolean delete(final String code) {
        return sysUserService.delete(code);
    }

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编号
     * @return 系统用户的响应对象
     */
    public SysUserResponse findByCode(final String code) {
        final SysUserDto sysUserDto = sysUserService.findByCode(code);
        return sysUserDtoConverter.dtoToResponse(sysUserDto);
    }

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 系统用户的响应对象
     */
    public PageResponse<SysUserResponse> pageByCondition(final SysUserRequest sysUserRequest) {
        final SysUserDto sysUserDto = sysUserDtoConverter.requestToDto(sysUserRequest);
        final Page<SysUserDto> sysUserDtos = sysUserService.pageByCondition(sysUserDto);
        return sysUserDtoConverter.dtoPageToResponsePage(sysUserDtos);
    }

    /**
     * 根据编号重置密码
     *
     * @param code 编号
     * @return 是否重置成功
     */
    @Override
    public boolean resetPassword(final String code) {
        return sysUserService.resetPassword(code);
    }

    /**
     * 系统用户数据传输类转换接口
     */
    @Resource
    private SysUserDtoConverter sysUserDtoConverter;

    /**
     * 系统用户的业务处理接口
     */
    @Resource
    private SysUserService sysUserService;

}
