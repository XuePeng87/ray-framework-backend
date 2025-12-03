package cc.xuepeng.ray.framework.facade.system.log.api;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.log.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.facade.system.log.response.SysOperateLogResponse;
import cc.xuepeng.ray.framework.facade.system.log.service.SysOperateLogFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统操作日志的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/operate-logs")
@Slf4j
@Validated
@SaCheckLogin
public class SysOperateLogController extends BaseController {

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogRequest 系统操作日志的请求对象
     * @return 系统操作日志的响应对象集合
     */
    @GetMapping("/v1/page")
    @OperateLog(module = "系统管理", func = "操作日志管理", remark = "分页查询操作日志",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<PageResponse<SysOperateLogResponse>> pageByCondition(final SysOperateLogRequest sysOperateLogRequest) {
        final PageResponse<SysOperateLogResponse> result = sysOperateLogFacade.pageByCondition(sysOperateLogRequest);
        return DefaultResultFactory.success("分页查询操作日志列表", result);
    }

    /**
     * 系统认证日志的门面接口
     */
    @Resource
    private SysOperateLogFacade sysOperateLogFacade;

}