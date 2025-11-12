package cc.xuepeng.ray.framework.sdk.auth.service.impl;

import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserFunc;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.sdk.auth.service.IdentificationService;
import cn.dev33.satoken.stp.StpInterface;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限认证接口的实现类
 *
 * @author xuepeng
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    /**
     * 获取当前登录用户的功能
     *
     * @param o 账号主键
     * @param s 账号类型
     * @return 当前登录用户的功能
     */
    @Override
    public List<String> getPermissionList(Object o, String s) {
        final List<CurrentUserFunc> funcs = identificationService.getCurrentUser().getFuncs();
        return this.getPermissions(funcs);
    }

    private List<String> getPermissions(final List<CurrentUserFunc> funcs) {
        final List<String> permissions = new ArrayList<>();
        for (CurrentUserFunc func : funcs) {
            permissions.add(func.getComponent());
            if (CollectionUtils.isNotEmpty(func.getChildren())) {
                permissions.addAll(getPermissions(func.getChildren()));
            }
        }
        return permissions;
    }

    /**
     * 获取当前登录用户的角色
     *
     * @param o 账号主键
     * @param s 账号类型
     * @return 当前登录用户的角色
     */
    @Override
    public List<String> getRoleList(Object o, String s) {
        final List<CurrentUserRole> roles = identificationService.getCurrentUser().getRoles();
        return roles.stream().map(CurrentUserRole::getName).toList();
    }

    /**
     * 认证的业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

}
