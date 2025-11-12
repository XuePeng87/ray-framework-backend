package cc.xuepeng.ray.framework.module.log.service.service;

import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDetailDto;

public interface SysOperateLogDetailService {

    /**
     * 创建系统操作日志详情
     *
     * @param sysOperateLogDetailDto 系统操作日志详情的数据传输对象
     */
    void create(final SysOperateLogDetailDto sysOperateLogDetailDto);

    /**
     * 根据日志主键查询系统操作日志详情
     *
     * @param logId 日志主键
     * @return 系统操作日志详情的数据传输对象
     */
    SysOperateLogDetailDto findByLogId(final Long logId);

}
