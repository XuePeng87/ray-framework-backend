package cc.xuepeng.ray.framework.module.log.api.facade;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.log.api.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.module.log.api.response.SysOperateLogDetailResponse;
import cc.xuepeng.ray.framework.module.log.api.response.SysOperateLogResponse;

/**
 * 系统操作日志的门面接口
 *
 * @author xuepeng
 */
public interface SysOperateLogFacade {

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogRequest 系统操作日志的请求对象
     * @return 系统操作日志分页数据
     */
    PageResponse<SysOperateLogResponse> pageByCondition(final SysOperateLogRequest sysOperateLogRequest);


    /**
     * 根据日志主键查询系统操作日志详情
     *
     * @param logId 日志主键
     * @return 系统操作日志详情的响应对象
     */
    SysOperateLogDetailResponse findByLogId(final Long logId);

}
