package cc.xuepeng.ray.framework.core.log.service.impl;

import cc.xuepeng.ray.framework.core.log.converter.SysAuthLogEntityConverter;
import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.log.entity.SysAuthLog;
import cc.xuepeng.ray.framework.core.log.repository.SysAuthLogRepository;
import cc.xuepeng.ray.framework.core.log.service.SysAuthLogService;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 系统登录登出的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysAuthLogServiceImpl
        extends ServiceImpl<SysAuthLogRepository, SysAuthLog>
        implements SysAuthLogService {

    /**
     * 创建系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     */
    @Override
    public void create(final SysAuthLogDto sysAuthLogDto) {
        final SysAuthLog sysAuthLog = sysAuthLogEntityConverter.dtoToEntity(sysAuthLogDto);
        super.save(sysAuthLog);
    }

    /**
     * 分页查询系统登录登出日志
     *
     * @param sysAuthLogDto 系统登录登出日志的数据传输对象
     * @return 系统登录登出日志分页数据
     */
    @Override
    public Page<SysAuthLogDto> pageByCondition(final SysAuthLogDto sysAuthLogDto) {
        final SysAuthLog sysAuthLog = this.sysAuthLogEntityConverter.dtoToEntity(sysAuthLogDto);
        final QueryWrapper<SysAuthLog> wrapper = QueryWrapperUtil.createQueryWrapper();
        final LambdaQueryWrapper<SysAuthLog> lambda = wrapper.lambda();
        lambda.eq(ObjectUtils.isNotEmpty(sysAuthLog.getType()), SysAuthLog::getType, sysAuthLog.getType());
        lambda.eq(StringUtils.isNotBlank(sysAuthLog.getCreateUser()), SysAuthLog::getCreateUser, sysAuthLog.getCreateUser());
        lambda.eq(StringUtils.isNotBlank(sysAuthLog.getLoginIp()), SysAuthLog::getLoginIp, sysAuthLog.getLoginIp());
        if (ObjectUtils.isNotEmpty(sysAuthLogDto.getBeginCreateTime())
                && ObjectUtils.isNotEmpty(sysAuthLogDto.getEndCreateTime())) {
            lambda.between(SysAuthLog::getCreateTime,
                    sysAuthLogDto.getBeginCreateTime(),
                    sysAuthLogDto.getEndCreateTime());
        }
        lambda.orderByDesc(SysAuthLog::getCreateTime);
        final Page<SysAuthLog> page = PageUtil.createPage(sysAuthLogDto);
        final Page<SysAuthLog> logs = super.page(page, wrapper);
        return this.sysAuthLogEntityConverter.entityPageToDtoPage(logs);
    }

    /**
     * 系统登录登出日志实体类转换接口
     */
    @Resource
    private SysAuthLogEntityConverter sysAuthLogEntityConverter;

}
