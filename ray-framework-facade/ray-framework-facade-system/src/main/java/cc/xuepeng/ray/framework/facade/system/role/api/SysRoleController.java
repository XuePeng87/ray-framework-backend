package cc.xuepeng.ray.framework.facade.system.role.api;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.role.request.SysRoleRequest;
import cc.xuepeng.ray.framework.facade.system.role.response.SysRoleResponse;
import cc.xuepeng.ray.framework.facade.system.role.service.SysRoleFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统角色的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/roles")
@Slf4j
@Validated
@SaCheckLogin
public class SysRoleController extends BaseController {

    /**
     * 创建系统角色
     *
     * @param sysRoleRequest 系统角色的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "创建角色", action = SysOperateLogAction.CREATE)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class) @RequestBody final SysRoleRequest sysRoleRequest
    ) {
        return sysRoleFacade.create(sysRoleRequest) ?
                DefaultResultFactory.success("创建系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建系统角色失败", Boolean.FALSE);
    }

    /**
     * 修改系统角色
     *
     * @param code         系统角色的编号
     * @param sysRoleRequest 系统角色的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "修改角色", action = SysOperateLogAction.UPDATE)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.create.class) @RequestBody final SysRoleRequest sysRoleRequest
    ) {
        return sysRoleFacade.update(code, sysRoleRequest) ?
                DefaultResultFactory.success("修改系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改系统角色失败", Boolean.FALSE);
    }

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "删除角色", action = SysOperateLogAction.DELETE)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysRoleFacade.delete(code) ?
                DefaultResultFactory.success("删除系统角色成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统角色失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的响应对象
     */
    @GetMapping("/v1/{code}")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "查询角色",
            action = SysOperateLogAction.DETAIL, persistent = false)
    public Result<SysRoleResponse> findByCode(@PathVariable(value = "code") final String code) {
        final SysRoleResponse result = sysRoleFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统角色", result);
    }

    /**
     * 查询系统角色
     *
     * @param sysRoleRequest 系统角色的请求对象
     * @return 系统角色的响应对象集合
     */
    @GetMapping("/v1/list")
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    @OperateLog(module = "系统管理", func = "角色管理", remark = "查询角色列表",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<List<SysRoleResponse>> listByCondition(final SysRoleRequest sysRoleRequest) {
        final List<SysRoleResponse> result = sysRoleFacade.listByCondition(sysRoleRequest);
        return DefaultResultFactory.success("查询系统角色列表", result);
    }

    /**
     * 分页查询系统角色
     *
     * @param sysRoleRequest 系统角色的请求对象
     * @return 系统角色的响应对象集合
     */
    @GetMapping("/v1/page")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "分页查询角色",
            action = SysOperateLogAction.QUERY, persistent = false)
    public Result<PageResponse<SysRoleResponse>> pageByCondition(final SysRoleRequest sysRoleRequest) {
        final PageResponse<SysRoleResponse> result = sysRoleFacade.pageByCondition(sysRoleRequest);
        return DefaultResultFactory.success("分页查询角色列表", result);
    }

    /**
     * 授权系统功能到系统角色
     *
     * @param code      系统角色的编号
     * @param funcCodes 系统功能的编号集合
     */
    @PostMapping("/v1/{code}/grant-func")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "保存授权功能", action = SysOperateLogAction.GRANT)
    public Result<Boolean> grantFunc(@PathVariable(value = "code") final String code,
                                     @RequestBody final List<String> funcCodes) {
        sysRoleFacade.saveFuncToRole(code, funcCodes);
        return DefaultResultFactory.success("授权功能成功", Boolean.TRUE);
    }

    /**
     * 查询系统角色所授权的系统功能
     *
     * @param code 系统角色的编号
     * @return 系统功能的编号集合
     */
    @GetMapping("/v1/{code}/grant-func")
    @SaCheckRole("ROLE_SUPER_ADMIN")
    @OperateLog(module = "系统管理", func = "角色管理", remark = "查询授权功能",
            action = SysOperateLogAction.GRANT, persistent = false)
    public Result<List<String>> findFunc(@PathVariable(value = "code") final String code) {
        return DefaultResultFactory.success("查询授权功能",
                sysRoleFacade.findFuncCodesByCode(code));
    }

    /**
     * 系统角色的业务处理门面接口
     */
    @Resource
    private SysRoleFacade sysRoleFacade;

}
