package cc.xuepeng.ray.framework.facade.system.dict.api;

import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.dict.request.SysDictRequest;
import cc.xuepeng.ray.framework.facade.system.dict.response.SysDictResponse;
import cc.xuepeng.ray.framework.facade.system.dict.service.SysDictFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统字典的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/dicts")
@Slf4j
@Validated
@SaCheckLogin
public class SysDictController extends BaseController {

    /**
     * 创建系统字典
     *
     * @param sysDictRequest 系统字典的请求对象
     * @return 是否创建成功
     */
    @PostMapping("/v1")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "创建字典",
            action = SysOperateLogAction.CREATE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> create(
            @Validated(RequestValidateScope.create.class)
            @RequestBody final SysDictRequest sysDictRequest) {
        return sysDictFacade.create(sysDictRequest) ?
                DefaultResultFactory.success("创建系统字典成功", Boolean.TRUE) :
                DefaultResultFactory.error("创建系统字典失败", Boolean.FALSE);
    }

    /**
     * 修改系统字典
     *
     * @param code         系统字典的编号
     * @param sysDictRequest 系统字典的请求对象
     * @return 是否修改成功
     */
    @PutMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "修改字典", action = SysOperateLogAction.UPDATE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> update(
            @PathVariable(value = "code") final String code,
            @Validated(RequestValidateScope.create.class) @RequestBody final SysDictRequest sysDictRequest
    ) {
        return sysDictFacade.update(code, sysDictRequest) ?
                DefaultResultFactory.success("修改系统字典成功", Boolean.TRUE) :
                DefaultResultFactory.error("修改系统字典失败", Boolean.FALSE);
    }

    /**
     * 删除系统字典
     *
     * @param codes 系统字典的编号集合
     * @return 是否删除成功
     */
    @DeleteMapping("/v1")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "删除字典", action = SysOperateLogAction.DELETE)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<Boolean> delete(@RequestBody final List<String> codes) {
        return sysDictFacade.delete(codes) ?
                DefaultResultFactory.success("删除系统字典成功", Boolean.TRUE) :
                DefaultResultFactory.error("删除系统字典失败", Boolean.FALSE);
    }

    /**
     * 根据编号查询系统字典
     *
     * @param code 系统字典的编号
     * @return 系统字典的响应对象
     */
    @GetMapping("/v1/{code}")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "查询字典",
            action = SysOperateLogAction.DETAIL, persistent = false)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<SysDictResponse> findByCode(@PathVariable(value = "code") final String code) {
        final SysDictResponse result = sysDictFacade.findByCode(code);
        return DefaultResultFactory.success("查询系统字典", result);
    }

    /**
     * 分页查询系统字典
     *
     * @param sysDictRequest 系统字典的请求对象
     * @return 系统字典的响应对象集合
     */
    @GetMapping("/v1/page")
    @OperateLog(module = "系统管理", func = "字典管理", remark = "分页查询字典",
            action = SysOperateLogAction.QUERY, persistent = false)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<PageResponse<SysDictResponse>> pageByCondition(final SysDictRequest sysDictRequest) {
        final PageResponse<SysDictResponse> result = sysDictFacade.pageByCondition(sysDictRequest);
        return DefaultResultFactory.success("分页查询字典列表", result);
    }

    /**
     * 系统字典的业务处理门面接口
     */
    @Resource
    private SysDictFacade sysDictFacade;

}
