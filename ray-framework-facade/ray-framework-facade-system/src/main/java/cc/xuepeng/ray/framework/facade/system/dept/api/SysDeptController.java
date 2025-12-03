package cc.xuepeng.ray.framework.facade.system.dept.api;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.dept.request.SysDeptRequest;
import cc.xuepeng.ray.framework.facade.system.dept.response.SysDeptResponse;
import cc.xuepeng.ray.framework.facade.system.dept.service.SysDeptFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统部门的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/depts")
@Slf4j
@Validated
@SaCheckLogin
public class SysDeptController extends BaseController {

    /**
     * 创建系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "创建部门", action = SysOperateLogAction.CREATE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class)
            @RequestBody final SysDeptRequest sysDeptRequest
    ) {
        return sysDeptFacade.create(sysDeptRequest) ?
                DefaultResultFactory.success("创建部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("创建部门失败", Boolean.FALSE);
    }

    /**
     * 修改系统部门
     *
     * @param code           系统部门的编号
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "修改部门", action = SysOperateLogAction.UPDATE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.update.class) @RequestBody final SysDeptRequest sysDeptRequest
    ) {
        return sysDeptFacade.update(code, sysDeptRequest) ?
                DefaultResultFactory.success("修改部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("修改部门失败", Boolean.FALSE);
    }

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    @DeleteMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "删除部门", action = SysOperateLogAction.DELETE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> delete(@PathVariable(value = "code") final String code) {
        return sysDeptFacade.delete(code) ?
                DefaultResultFactory.success("删除系统部门成功", Boolean.TRUE) :
                DefaultResultFactory.fail("删除系统部门失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    @GetMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "查询部门",
            action = SysOperateLogAction.DETAIL, ignoreResponse = true)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<SysDeptResponse> findByCode(@PathVariable(value = "code") final String code) {
        final SysDeptResponse result = sysDeptFacade.findByCode(code);
        return DefaultResultFactory.success("根据编号查询部门", result);
    }

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    @GetMapping("/v1")
    @OperateLog(module = "系统管理", func = "部门管理", remark = "查询部门树",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<List<SysDeptResponse>> treeByCondition(
            @Validated(RequestValidateScope.page.class) final SysDeptRequest sysDeptRequest
    ) {
        final List<SysDeptResponse> result = sysDeptFacade.treeByCondition(sysDeptRequest);
        return DefaultResultFactory.success("查询系统部门", result);
    }

    /**
     * 系统部门的门面接口
     */
    @Resource
    private SysDeptFacade sysDeptFacade;

}
