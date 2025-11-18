package cc.xuepeng.ray.framework.module.log.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.log.dto.SysOperateLogDetailDto;
import cc.xuepeng.ray.framework.module.log.entity.SysOperateLogDetail;
import cc.xuepeng.ray.framework.module.log.repository.SysOperateLogDetailRepository;
import cc.xuepeng.ray.framework.module.log.converter.SysOperateLogDetailEntityConverter;
import cc.xuepeng.ray.framework.module.log.service.SysOperateLogDetailService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志详情的业务处理类
 *
 * @author xuepeng
 */
@Component
public class SysOperateLogDetailServiceImpl
        extends ServiceImpl<SysOperateLogDetailRepository, SysOperateLogDetail>
        implements SysOperateLogDetailService {

    /**
     * 创建系统操作日志详情
     *
     * @param sysOperateLogDetailDto 系统操作日志详情的数据传输对象
     */
    @Override
    public void create(final SysOperateLogDetailDto sysOperateLogDetailDto) {
        final SysOperateLogDetail sysOperateLogDetail =
                sysOperateLogDetailEntityConverter.dtoToEntity(sysOperateLogDetailDto);
        super.save(sysOperateLogDetail);
    }

    /**
     * 根据日志主键查询系统操作日志详情
     *
     * @param logId 日志主键
     * @return 系统操作日志详情的数据传输对象
     */
    @Override
    public SysOperateLogDetailDto findByLogId(final Long logId) {
        final QueryWrapper<SysOperateLogDetail> wrapper = QueryWrapperUtil.createQueryWrapper();
        final LambdaQueryWrapper<SysOperateLogDetail> lambda = wrapper.lambda();
        lambda.eq(SysOperateLogDetail::getLogId, logId);
        final SysOperateLogDetail detail = super.getOne(lambda, QueryConst.QUERY_NULL_THROW_EX);
        return sysOperateLogDetailEntityConverter.entityToDto(detail);
    }

    /**
     * 系统操作日志详情实体类转换接口
     */
    @Resource
    private SysOperateLogDetailEntityConverter sysOperateLogDetailEntityConverter;


}
