package cc.xuepeng.ray.framework.facade.system.tenent.api;

import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.tenent.request.SysTenantRequest;
import cc.xuepeng.ray.framework.facade.system.tenent.response.SysTenantResponse;
import cc.xuepeng.ray.framework.facade.system.tenent.service.SysTenantFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统租户的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/tenants")
@Validated
@SaCheckLogin
public class SysTenantController extends BaseController {

    /**
     * 创建系统租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 租户管理员的登录密码
     */
    @PostMapping("/v1")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN"})
    @OperateLog(module = "系统管理", func = "租户管理", remark = "创建租户", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final SysTenantRequest sysTenantRequest
    ) {
        return sysTenantFacade.create(sysTenantRequest) ?
                DefaultResultFactory.success("创建租户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建租户失败", Boolean.FALSE);
    }

    /**
     * 修改系统租户
     *
     * @param code             系统租户编号
     * @param sysTenantRequest 系统租户的请求对象
     * @return 是否修改成功
     */
    @OperateLog(module = "系统管理", func = "租户管理", remark = "修改租户", action = SysOperateLogAction.UPDATE)
    @ModifyUser
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN"})
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.update.class) @RequestBody final SysTenantRequest sysTenantRequest
    ) {
        return sysTenantFacade.update(code, sysTenantRequest) ?
                DefaultResultFactory.success("修改租户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改租户成功", Boolean.FALSE);
    }

    /**
     * 删除系统租户
     *
     * @param code 系统租户编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "租户管理", remark = "删除租户", action = SysOperateLogAction.DELETE)
    @ModifyUser
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN"})
    public Result<Boolean> delete(
            @PathVariable(value = "code") final String code
    ) {
        return sysTenantFacade.delete(code) ?
                DefaultResultFactory.success("删除租户成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除租户成功", Boolean.FALSE);
    }

    /**
     * 根据条件分页查询系统租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 系统租户的响应对象集合
     */
    @GetMapping("/v1")
    @OperateLog(module = "系统管理", func = "租户管理", remark = "分页查询租户",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<PageResponse<SysTenantResponse>> pageByCondition(
            @Validated(RequestValidateScope.page.class) final SysTenantRequest sysTenantRequest
    ) {
        final PageResponse<SysTenantResponse> result = sysTenantFacade.pageByCondition(sysTenantRequest);
        return DefaultResultFactory.success("分页查询系统租户", result);
    }

    /**
     * 系统租户的业务处理门面接口
     */
    @Resource
    private SysTenantFacade sysTenantFacade;

}
