package cc.xuepeng.ray.framework.facade.system.log.service.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.log.service.SysAuthLogService;
import cc.xuepeng.ray.framework.facade.system.log.converter.SysAuthLogDtoConverter;
import cc.xuepeng.ray.framework.facade.system.log.request.SysAuthLogRequest;
import cc.xuepeng.ray.framework.facade.system.log.response.SysAuthLogResponse;
import cc.xuepeng.ray.framework.facade.system.log.service.SysAuthLogFacade;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统认证日志的门面接口实现类
 *
 * @author xuepeng
 */
@Component
public class SysAuthLogFacadeImpl implements SysAuthLogFacade {


    /**
     * 分页查询系统登录登出日志
     *
     * @param sysAuthLogRequest 系统认证日志的请求对象
     * @return 系统登录登出日志分页数据
     */
    @Override
    public PageResponse<SysAuthLogResponse> pageByCondition(SysAuthLogRequest sysAuthLogRequest) {
        final SysAuthLogDto sysAuthLogDto = sysAuthLogDtoConverter.requestToDto(sysAuthLogRequest);
        final Page<SysAuthLogDto> result = sysAuthLogService.pageByCondition(sysAuthLogDto);
        return sysAuthLogDtoConverter.dtoPageToResponsePage(result);
    }

    /**
     * 系统登录登出日志数据传输类转换接口
     */
    @Resource
    private SysAuthLogDtoConverter sysAuthLogDtoConverter;

    /**
     * 系统登录登出日志的服务处理接口
     */
    @Resource
    private SysAuthLogService sysAuthLogService;

}