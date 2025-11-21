package cc.xuepeng.ray.framework.module.dept.service.impl;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.dept.converter.SysDeptEntityConverter;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.dept.entity.SysDept;
import cc.xuepeng.ray.framework.module.dept.exception.SysDeptDuplicateException;
import cc.xuepeng.ray.framework.module.dept.exception.SysDeptNotFoundException;
import cc.xuepeng.ray.framework.module.dept.repository.SysDeptRepository;
import cc.xuepeng.ray.framework.module.dept.service.SysDeptService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统部门的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysDeptServiceImpl
        extends ServiceImpl<SysDeptRepository, SysDept>
        implements SysDeptService {

    /**
     * 创建系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final SysDeptDto sysDeptDto) {
        final String name = sysDeptDto.getName();
        if (checkNameExisted(StringUtils.EMPTY, name)) {
            throw new SysDeptDuplicateException("系统部门名称[" + name + "]已存在");
        }
        sysDeptDto.setCode(RandomUtil.get32UUID());
        final SysDept sysDept = sysDeptEntityConverter.dtoToEntity(sysDeptDto);
        return super.save(sysDept);
    }

    /**
     * 修改系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final SysDeptDto sysDeptDto) {
        final String code = sysDeptDto.getCode();
        final String name = sysDeptDto.getName();
        if (checkNameExisted(code, name)) {
            throw new SysDeptDuplicateException("系统部门名称[" + name + "]已存在");
        }
        final SysDept sysDept = sysDeptEntityConverter.dtoToEntity(sysDeptDto);
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper(code);
        return super.update(sysDept, wrapper);
    }

    /**
     * 根据编号删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        // TODO 判断子部门和用户
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper(code);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的数据传输对象
     */
    @Override
    public SysDeptDto findByCode(final String code) {
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper(code);
        final SysDept sysDept = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysDept)) {
            throw new SysDeptNotFoundException("无法根据编号[" + code + "]查询到系统部门");
        }
        return sysDeptEntityConverter.entityToDto(sysDept);
    }

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 系统部门的数据传输对象集合
     */
    @Override
    public List<SysDeptDto> listByCondition(final SysDeptDto sysDeptDto) {
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper(sysDeptDto);
        final List<SysDept> sysDepts = super.list(wrapper);
        return sysDeptEntityConverter.entityListToDtoList(sysDepts);
    }

    /**
     * 检测系统部门名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 系统部门名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper();
        final List<SysDept> sysDepts = super.list(wrapper.lambda().eq(SysDept::getName, name));
        return ExistsUtil.exists(
                sysDepts,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysDept> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysDept> createQueryWrapper(final String code) {
        final QueryWrapper<SysDept> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysDept> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysDept::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysDept> createQueryWrapper(final SysDeptDto sysDeptDto) {
        final QueryWrapper<SysDept> wrapper = QueryWrapperUtil.createQueryWrapper(sysDeptDto);
        final SysDept sysDept = sysDeptEntityConverter.dtoToEntity(sysDeptDto);
        final LambdaQueryWrapper<SysDept> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysDept.getCode()), SysDept::getCode, sysDept.getCode());
        lambda.eq(ObjectUtils.isNotEmpty(sysDept.getStatus()), SysDept::getStatus, sysDept.getStatus());
        lambda.like(StringUtils.isNotBlank(sysDept.getName()), SysDept::getName, sysDept.getName());
        lambda.orderByAsc(SysDept::getSequence);
        return wrapper;
    }

    /**
     * 系统部门实体类转换接口
     */
    @Resource
    private SysDeptEntityConverter sysDeptEntityConverter;

}
