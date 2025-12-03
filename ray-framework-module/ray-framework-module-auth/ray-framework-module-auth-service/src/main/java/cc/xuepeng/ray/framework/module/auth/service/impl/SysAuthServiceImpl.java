package cc.xuepeng.ray.framework.module.auth.service.impl;

import cc.xuepeng.ray.framework.core.auth.model.*;
import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.common.enums.SystemRole;
import cc.xuepeng.ray.framework.module.auth.converter.CurrentUserConverter;
import cc.xuepeng.ray.framework.module.auth.dto.SysLoginDto;
import cc.xuepeng.ray.framework.module.auth.exception.SysLoginFailedException;
import cc.xuepeng.ray.framework.module.auth.service.SysAuthService;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.dept.service.SysDeptService;
import cc.xuepeng.ray.framework.module.func.decorator.SysFuncFormat;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.role.dto.SysRoleDto;
import cc.xuepeng.ray.framework.module.role.service.SysRoleFuncGrantService;
import cc.xuepeng.ray.framework.module.role.service.SysRoleService;
import cc.xuepeng.ray.framework.module.role.service.SysRoleUserGrantService;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import cc.xuepeng.ray.framework.module.tenant.service.SysTenantService;
import cc.xuepeng.ray.framework.module.user.dto.SysUserDto;
import cc.xuepeng.ray.framework.module.user.exception.SysUserNotFoundException;
import cc.xuepeng.ray.framework.module.user.service.SysUserService;
import cc.xuepeng.ray.framework.module.func.service.SysFuncService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 系统认证的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysAuthServiceImpl implements SysAuthService {

    /**
     * 系统登录
     *
     * @param sysLoginDto 系统登录的数据传输对象
     * @return 访问令牌
     */
    @Override
    public String login(final SysLoginDto sysLoginDto) {
        try {
            // 设置用户
            final SysUserDto sysUserDto = sysUserService.findByPhoneNumberAndPassword(
                    sysLoginDto.getPhoneNumber(),
                    sysLoginDto.getPassword()
            );
            final CurrentUser currentUser = currentUserConverter.sysUserToCurrentUser(sysUserDto);
            // 设置租户
            final SysTenantDto sysTenantDto = sysTenantService.findByCode(sysUserDto.getTenantCode());
            final CurrentUserTenant currentUserTenant = currentUserConverter.sysTenantToCurrentUserTenant(sysTenantDto);
            currentUser.setTenant(currentUserTenant);
            // 设置部门
            final SysDeptDto sysDeptDto = sysDeptService.findByCode(sysUserDto.getDeptCode());
            final CurrentUserDept currentUserDept = currentUserConverter.sysDeptToCurrentUserDept(sysDeptDto);
            currentUser.setDept(currentUserDept);
            // 设置角色
            final List<String> roleCodes = sysRoleUserGrantService.findRolesByUserCode(sysUserDto.getCode());
            final List<SysRoleDto> sysRoleDtos = sysRoleService.findByCodes(roleCodes);
            final List<CurrentUserRole> currentUserRole = currentUserConverter.sysRoleListToCurrentUserRoleList(sysRoleDtos);
            currentUser.setRoles(currentUserRole);
            // 设置管理员
            currentUser.setAdmin(sysRoleDtos.stream()
                    .map(SysRoleDto::getName)
                    .anyMatch(
                            Set.of(SystemRole.SUPER_ADMIN.getDesc(), SystemRole.SYSTEM_ADMIN.getDesc())::contains
                    )
            );
            // 设置功能
            final List<String> funcCodes = sysRoleFuncGrantService.findFuncsByRoleCodes(roleCodes);
            final List<SysFuncDto> sysFuncDtos = sysFuncService.findByCodes(funcCodes);
            final List<SysFuncDto> funcTree = sysFuncFormat.tree(sysFuncDtos);
            final List<CurrentUserFunc> currentUserFunc = currentUserConverter.sysFuncListToCurrentUserFuncList(funcTree);
            currentUser.setFuncs(currentUserFunc);
            // 设置权限
            final List<String> permissions = sysFuncDtos.stream().map(SysFuncDto::getPermission).toList();
            currentUser.setPermissions(permissions);
            // 登录系统
            return identificationService.login(currentUser);
        } catch (SysUserNotFoundException e) {
            throw new SysLoginFailedException("用户名或密码不正确");
        }
    }

    /**
     * @return 获取当前登录人
     */
    @Override
    public CurrentUser getCurrentUser() {
        return identificationService.getCurrentUser();
    }

    /**
     * 系统登出
     */
    @Override
    public void logout() {
        identificationService.logout();
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

    /**
     * 系统用户的业务处理接口
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 系统租户的业务处理接口
     */
    @Resource
    private SysTenantService sysTenantService;

    /**
     * 系统部门的业务处理接口
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 系统角色与用户关系的业务处理接口
     */
    @Resource
    private SysRoleUserGrantService sysRoleUserGrantService;

    /**
     * 系统角色与功能关系的业务处理接口
     */
    @Resource
    private SysRoleFuncGrantService sysRoleFuncGrantService;

    /**
     * 系统角色的业务处理接口
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 系统功能的业务处理接口
     */
    @Resource
    private SysFuncService sysFuncService;

    /**
     * 系统功能格式化接口
     */
    @Resource
    private SysFuncFormat sysFuncFormat;

    /**
     * 系统登录用户对象转换接口
     */
    @Resource
    private CurrentUserConverter currentUserConverter;

}
