package cc.xuepeng.ray.framework.module.log.service.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.module.log.domain.dto.SysOperateLogDto;
import cc.xuepeng.ray.framework.module.log.repository.entity.SysOperateLog;
import cc.xuepeng.ray.framework.module.log.repository.enums.SysOperateLogType;
import cc.xuepeng.ray.framework.module.log.repository.repository.SysOperateLogRepository;
import cc.xuepeng.ray.framework.module.log.service.converter.SysOperateLogEntityConverter;
import cc.xuepeng.ray.framework.module.log.service.service.SysOperateLogService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统操作日志的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysOperateLogServiceImpl
        extends ServiceImpl<SysOperateLogRepository, SysOperateLog>
        implements SysOperateLogService {

    /**
     * 创建系统操作日志
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(final SysOperateLogDto sysOperateLogDto) {
        final SysOperateLog operateLog = sysOperateLogEntityConverter.dtoToEntity(sysOperateLogDto);
        operateLog.setType(SysOperateLogType.ACCESS);
        super.save(operateLog);
        final SysOperateLogDetailDto sysOperateLogDetailDto = sysOperateLogDto.getDetail();
        sysOperateLogDetailDto.setLogId(operateLog.getId());
        sysOperateLogDetailServiceImpl.create(sysOperateLogDto.getDetail());
    }

    /**
     * 分页查询系统操作日志
     *
     * @param sysOperateLogDto 系统操作日志的数据传输对象
     * @return 系统操作日志的分页数据
     */
    @Override
    public Page<SysOperateLogDto> pageByCondition(final SysOperateLogDto sysOperateLogDto) {
        final SysOperateLog sysOperateLog = sysOperateLogEntityConverter.dtoToEntity(sysOperateLogDto);
        final QueryWrapper<SysOperateLog> wrapper = QueryWrapperUtil.createQueryWrapper();
        final LambdaQueryWrapper<SysOperateLog> lambda = wrapper.lambda();
        lambda.eq(ObjectUtils.isNotEmpty(sysOperateLog.getType()), SysOperateLog::getType, sysOperateLog.getType());
        lambda.eq(StringUtils.isNotBlank(sysOperateLog.getModule()), SysOperateLog::getModule, sysOperateLog.getModule());
        if (ObjectUtils.isNotEmpty(sysOperateLogDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysOperateLogDto.getEndCreateTime())) {
            lambda.between(SysOperateLog::getCreateTime,
                    sysOperateLogDto.getBeginCreateTime(),
                    sysOperateLogDto.getEndCreateTime());
        }
        lambda.orderByDesc(SysOperateLog::getCreateTime);
        final Page<SysOperateLog> page = PageUtil.createPage(sysOperateLogDto);
        final Page<SysOperateLog> logs = super.page(page, wrapper);
        return sysOperateLogEntityConverter.entityPageToDtoPage(logs);
    }

    /**
     * 系统操作日志实体类转换接口
     */
    @Resource
    private SysOperateLogEntityConverter sysOperateLogEntityConverter;

    /**
     * 系统操作日志详情的业务处理对象
     */
    @Resource
    private SysOperateLogDetailServiceImpl sysOperateLogDetailServiceImpl;

}
