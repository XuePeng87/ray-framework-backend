package cc.xuepeng.ray.framework.facade.system.log.api;

import cc.xuepeng.ray.framework.core.common.domain.result.DefaultResultFactory;
import cc.xuepeng.ray.framework.core.common.domain.result.Result;
import cc.xuepeng.ray.framework.core.log.annotation.OperateLog;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogAction;
import cc.xuepeng.ray.framework.core.web.controller.BaseController;
import cc.xuepeng.ray.framework.facade.system.log.response.SysOperateLogDetailResponse;
import cc.xuepeng.ray.framework.facade.system.log.service.SysOperateLogFacade;
import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统操作日志详情的API接口
 *
 * @author xuepeng
 */
@RestController
@RequestMapping("/v1/operate-log-details")
@Slf4j
@Validated
@SaCheckLogin
public class SysOperateLogDetailController extends BaseController {

    /**
     * 根据日志主键查询系统操作日志详情
     *
     * @param logId 日志主键
     * @return 系统操作日志详情的响应对象
     */
    @GetMapping("/v1/{logId}")
    @OperateLog(module = "系统管理", func = "操作日志管理", remark = "查询操作日志详情",
            action = SysOperateLogAction.QUERY, ignoreResponse = true)
    @SaCheckRole(value = {"ROLE_SUPER_ADMIN", "ROLE_SYSTEM_ADMIN"}, mode = SaMode.OR)
    public Result<SysOperateLogDetailResponse> findByLogId(@PathVariable("logId") final Long logId) {
        final SysOperateLogDetailResponse result = sysOperateLogFacade.findByLogId(logId);
        return DefaultResultFactory.success("查询操作日志详情", result);
    }

    /**
     * 系统认证日志的门面接口
     */
    @Resource
    private SysOperateLogFacade sysOperateLogFacade;

}