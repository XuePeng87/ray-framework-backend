package cc.xuepeng.ray.framework.facade.system.user.api;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.user.request.SysUserRequest;
import cc.xuepeng.ray.framework.facade.system.user.response.SysUserResponse;
import cc.xuepeng.ray.framework.facade.system.user.service.SysUserFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/users")
@Slf4j
@Validated
@SaCheckLogin
public class SysUserController extends BaseController {

    /**
     * 创建系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "创建用户", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final SysUserRequest sysUserRequest
    ) {
        return sysUserFacade.create(sysUserRequest) ?
                DefaultResultFactory.success("创建系统用户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建系统用户失败", Boolean.FALSE);
    }

    /**
     * 修改系统用户
     *
     * @param code           系统用户的编码
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "修改用户", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.create.class) @RequestBody final SysUserRequest sysUserRequest) {
        return sysUserFacade.update(code, sysUserRequest) ?
                DefaultResultFactory.success("修改系统用户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改系统用户失败", Boolean.FALSE);
    }

    /**
     * 重置系统用户密码
     *
     * @param code 系统用户的编码
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}/reset-password")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "重置密码", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code) {
        return sysUserFacade.resetPassword(code) ?
                DefaultResultFactory.success("重置密码成功", Boolean.TRUE) :
                DefaultResultFactory.fail("重置密码失败", Boolean.FALSE);
    }

    /**
     * 删除系统用户
     *
     * @param code 系统用户的编码
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "删除用户", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysUserFacade.delete(code) ?
                DefaultResultFactory.success("删除系统用户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统用户失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编码
     * @return 系统用户的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "查询用户",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    public Result<SysUserResponse> findByCode(@PathVariable(value = "code") final String code) {
        final SysUserResponse result = sysUserFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统用户", result);
    }

    /**
     * 分页查询系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 系统用户的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN", "ROLE_TENANT_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "用户管理", remark = "分页查询用户",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    public Result<PageResponse<SysUserResponse>> pageByCondition(final SysUserRequest sysUserRequest) {
        final PageResponse<SysUserResponse> result = sysUserFacade.pageByCondition(sysUserRequest);
        return DefaultResultFactory.success("分页查询用户列表", result);
    }

    /**
     * 系统用户的业务处理门面接口
     */
    @Resource
    private SysUserFacade sysUserFacade;

}
