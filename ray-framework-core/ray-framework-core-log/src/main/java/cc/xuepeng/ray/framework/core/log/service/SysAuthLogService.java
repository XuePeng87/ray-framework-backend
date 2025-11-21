package cc.xuepeng.ray.framework.core.log.service;

import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统登录登出日志的服务处理接口
 *
 * @author xuepeng
 */
public interface SysAuthLogService {

    /**
     * 创建系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     */
    void create(final SysAuthLogDto sysAuthLogDto);

    /**
     * 分页查询系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     * @return 系统登录登出日志分页数据
     */
    Page<SysAuthLogDto> pageByCondition(final SysAuthLogDto sysAuthLogDto);

}
