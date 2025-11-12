package cc.xuepeng.ray.framework.module.log.api.facade.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.module.log.api.converter.SysOperateLogDetailDtoConverter;
import cc.xuepeng.ray.framework.module.log.api.converter.SysOperateLogDtoConverter;
import cc.xuepeng.ray.framework.module.log.api.facade.SysOperateLogFacade;
import cc.xuepeng.ray.framework.module.log.api.request.SysOperateLogRequest;
import cc.xuepeng.ray.framework.module.log.api.response.SysOperateLogDetailResponse;
import cc.xuepeng.ray.framework.module.log.api.response.SysOperateLogResponse;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.log.service.service.SysOperateLogDetailService;
import cc.xuepeng.ray.framework.module.log.service.service.SysOperateLogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志门面接口的实现类
 *
 * @author xuepeng
 */
@Component
public class SysOperateLogFacadeImpl implements SysOperateLogFacade {

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogRequest 系统操作日志的请求对象
     * @return 系统操作日志分页数据
     */
    @Override
    public PageResponse<SysOperateLogResponse> pageByCondition(final SysOperateLogRequest sysOperateLogRequest) {
        final SysOperateLogDto sysOperateLogDto = sysOperateLogDtoConverter.requestToDto(sysOperateLogRequest);
        final Page<SysOperateLogDto> result = sysOperateLogService.pageByCondition(sysOperateLogDto);
        return sysOperateLogDtoConverter.dtoPageToResponsePage(result);
    }


    /**
     * 根据日志主键查询系统操作日志详情
     *
     * @param logId 日志主键
     * @return 系统操作日志详情的响应对象
     */
    @Override
    public SysOperateLogDetailResponse findByLogId(final Long logId) {
        final SysOperateLogDetailDto sysOperateLogDetailDto = sysOperateLogDetailService.findByLogId(logId);
        return sysOperateLogDetailDtoConverter.dtoToResponse(sysOperateLogDetailDto);
    }

    /**
     * 系统操作日志数据传输类转换接口
     */
    @Resource
    private SysOperateLogDtoConverter sysOperateLogDtoConverter;

    /**
     * 系统操作日志详情数据传输类转换接口
     */
    @Resource
    private SysOperateLogDetailDtoConverter sysOperateLogDetailDtoConverter;

    /**
     * 系统操作日志的服务处理接口
     */
    @Resource
    private SysOperateLogService sysOperateLogService;

    /**
     * 系统操作日志详情的服务处理接口
     */
    @Resource
    private SysOperateLogDetailService sysOperateLogDetailService;

}
