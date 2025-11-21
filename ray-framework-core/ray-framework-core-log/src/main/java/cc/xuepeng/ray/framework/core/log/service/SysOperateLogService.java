package cc.xuepeng.ray.framework.core.log.service;

import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统操作日志的服务处理接口
 *
 * @author xuepeng
 */
public interface SysOperateLogService {

    /**
     * 创建系统操作日志
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     */
    void create(final SysOperateLogDto sysOperateLogDto);

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     * @return 系统操作日志的分页数据
     */
    Page<SysOperateLogDto> pageByCondition(final SysOperateLogDto sysOperateLogDto);

}
