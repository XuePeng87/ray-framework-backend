package cc.xuepeng.ray.framework.module.log.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.log.api.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.module.log.api.response.SysAuthLogResponse;

/**
 * 系统认证日志的门面接口
 *
 * @author xuepeng
 */
public interface SysAuthLogFacade {

    /**
     * 分页查询系统登录登出日志
     *
     * @param sysAuthLogRequest 系统认证日志的请求对象
     * @return 系统登录登出日志分页数据
     */
    PageResponse<SysAuthLogResponse> pageByCondition(final SysAuthLogRequest sysAuthLogRequest);

}