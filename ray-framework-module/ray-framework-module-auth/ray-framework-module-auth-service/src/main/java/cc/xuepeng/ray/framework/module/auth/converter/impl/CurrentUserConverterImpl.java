package cc.xuepeng.ray.framework.module.auth.converter.impl;

import cc.xuepeng.ray.framework.core.auth.model.*;
import cc.xuepeng.ray.framework.module.auth.converter.CurrentUserConverter;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.role.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.user.dto.SysUserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * CurrentUserConverterImpl类是CurrentUserConverter接口的实现类，
 * 负责将系统内部的各种数据传输对象（DTO）转换为当前用户模型对象。
 * <p>
 * 该类实现了以下功能：
 * 1. 将系统用户数据传输对象（SysUserDto）转换为当前用户对象（CurrentUser）。
 * - 映射用户编码、手机号、姓名、邮箱和头像信息。
 * 2. 将系统部门数据传输对象（SysDeptDto）转换为当前用户部门对象（CurrentUserDept）。
 * - 映射部门编码和名称信息。
 * 3. 将系统角色数据传输对象列表（List<SysRoleDto>）转换为当前用户角色对象列表（List<CurrentUserRole>）。
 * - 遍历角色列表，映射每个角色的编码和名称信息。
 * 4. 将系统功能数据传输对象列表（List<SysFuncDto>）转换为当前用户功能对象列表（List<CurrentUserFunc>）。
 * - 遍历功能列表，映射每个功能的路径、组件（如果不可链接）、重定向路径和名称。
 * - 设置功能的元数据，包括标题、图标、是否隐藏、是否保持活动和是否总是显示。
 * - 递归处理子功能列表，构建功能树结构。
 * <p>
 * 该类使用了Apache Commons库中的工具类（CollectionUtils和BooleanUtils）来简化集合和布尔值的处理。
 * 通过Spring的@Component注解，该类被声明为一个Spring管理的Bean，可以在需要的地方自动注入使用。
 *
 * @author xuepeng
 */
@Component
public class CurrentUserConverterImpl implements CurrentUserConverter {

    /**
     * 将系统用户数据传输对象转换为当前用户对象。
     *
     * @param sysUserDto 系统用户数据传输对象
     * @return 当前用户对象
     */
    @Override
    public CurrentUser sysUserToCurrentUser(final SysUserDto sysUserDto) {
        final CurrentUser currentUser = new CurrentUser();
        currentUser.setTenantCode(sysUserDto.getTenantCode());
        currentUser.setDeptCode(sysUserDto.getDeptCode());
        currentUser.setCode(sysUserDto.getCode());
        currentUser.setPhoneNumber(sysUserDto.getPhoneNumber());
        currentUser.setName(sysUserDto.getName());
        currentUser.setEmail(sysUserDto.getEmail());
        currentUser.setAvatar(sysUserDto.getAvatar());
        return currentUser;
    }

    /**
     * 将系统租户数据传输对象转换为当前用户租户对象。
     *
     * @param sysTenantDto 系统租户数据传输对象
     * @return 当前用户租户对象
     */
    @Override
    public CurrentUserTenant sysTenantToCurrentUserTenant(final SysTenantDto sysTenantDto) {
        final CurrentUserTenant currentUserTenant = new CurrentUserTenant();
        currentUserTenant.setCode(sysTenantDto.getCode());
        currentUserTenant.setName(sysTenantDto.getName());
        currentUserTenant.setEndExpireTime(sysTenantDto.getEndExpireTime());
        return currentUserTenant;
    }

    /**
     * 将系统部门数据传输对象转换为当前用户部门对象。
     *
     * @param sysDeptDto 系统部门数据传输对象
     * @return 当前用户部门对象
     */
    @Override
    public CurrentUserDept sysDeptToCurrentUserDept(final SysDeptDto sysDeptDto) {
        final CurrentUserDept currentUserDept = new CurrentUserDept();
        currentUserDept.setCode(sysDeptDto.getCode());
        currentUserDept.setName(sysDeptDto.getName());
        return currentUserDept;
    }

    /**
     * 将系统角色数据传输对象列表转换为当前用户角色对象列表。
     *
     * @param sysRoleDtos 系统角色数据传输对象列表
     * @return 当前用户角色对象列表
     */
    @Override
    public List<CurrentUserRole> sysRoleListToCurrentUserRoleList(final List<SysRoleDto> sysRoleDtos) {
        final List<CurrentUserRole> currentUserRoles = new ArrayList<>();
        for (SysRoleDto sysRoleDto : sysRoleDtos) {
            final CurrentUserRole currentUserRole = new CurrentUserRole();
            currentUserRole.setCode(sysRoleDto.getCode());
            currentUserRole.setName(sysRoleDto.getName());
            currentUserRoles.add(currentUserRole);
        }
        return currentUserRoles;
    }

    /**
     * 将系统功能数据传输对象列表转换为当前用户功能对象列表。
     *
     * @param sysFuncDtos 系统功能数据传输对象列表
     * @return 当前用户功能对象列表
     */
    @Override
    public List<CurrentUserFunc> sysFuncListToCurrentUserFuncList(final List<SysFuncDto> sysFuncDtos) {
        final List<CurrentUserFunc> currentUserFuncs = new ArrayList<>();
        for (SysFuncDto sysFuncDto : sysFuncDtos) {
            final CurrentUserFunc currentUserFunc = new CurrentUserFunc();
            currentUserFunc.setPath(sysFuncDto.getPath());
            if (BooleanUtils.isFalse(sysFuncDto.getLinkable())) {
                currentUserFunc.setComponent(sysFuncDto.getComponent());
            }
            currentUserFunc.setRedirect(sysFuncDto.getRedirect());
            currentUserFunc.setName(sysFuncDto.getPath());
            // 设置元数据
            final CurrentUserFunc.CurrentUserFuncMeta currentUserFuncMeta = new CurrentUserFunc.CurrentUserFuncMeta();
            currentUserFuncMeta.setTitle(sysFuncDto.getName());
            currentUserFuncMeta.setIcon(sysFuncDto.getIcon());
            currentUserFuncMeta.setHidden(!sysFuncDto.getVisible());
            currentUserFuncMeta.setKeepAlive(sysFuncDto.getCacheable());
            currentUserFuncMeta.setAlwaysShow(sysFuncDto.getAlwaysShow());
            currentUserFunc.setMeta(currentUserFuncMeta);
            // 添加到数据
            currentUserFuncs.add(currentUserFunc);
            if (CollectionUtils.isNotEmpty(sysFuncDto.getChildren())) {
                currentUserFunc.setChildren(this.sysFuncListToCurrentUserFuncList(sysFuncDto.getChildren()));
            }
        }
        return currentUserFuncs;
    }

}
