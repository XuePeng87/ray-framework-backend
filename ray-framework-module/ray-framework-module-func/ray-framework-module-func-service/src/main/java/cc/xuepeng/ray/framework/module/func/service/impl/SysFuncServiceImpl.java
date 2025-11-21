package cc.xuepeng.ray.framework.module.func.service.impl;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.func.converter.SysFuncEntityConverter;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.func.entity.SysFunc;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncCannotDeleteException;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncDuplicateException;
import cc.xuepeng.ray.framework.module.func.exception.SysFuncNotFoundException;
import cc.xuepeng.ray.framework.module.func.repository.SysFuncRepository;
import cc.xuepeng.ray.framework.module.func.service.SysFuncService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysFuncServiceImpl
        extends ServiceImpl<SysFuncRepository, SysFunc>
        implements SysFuncService {

    /**
     * 创建系统功能
     *
     * @param sysFuncDto 系统功能的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final SysFuncDto sysFuncDto) {
        final String name = sysFuncDto.getName();
        if (this.checkNameExisted(StringUtils.EMPTY, name)) {
            throw new SysFuncDuplicateException("系统功能名称[" + name + "]已存在");
        }
        sysFuncDto.setCode(RandomUtil.get32UUID());
        final SysFunc sysFunc = sysFuncEntityConverter.dtoToEntity(sysFuncDto);
        return super.save(sysFunc);
    }

    /**
     * 修改系统功能
     *
     * @param sysFuncDto 系统功能的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final SysFuncDto sysFuncDto) {
        final String code = sysFuncDto.getCode();
        final String name = sysFuncDto.getName();
        if (this.checkNameExisted(code, name)) {
            throw new SysFuncDuplicateException("系统功能名称[" + name + "]已存在");
        }
        final SysFunc sysFunc = sysFuncEntityConverter.dtoToEntity(sysFuncDto);
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper(code);
        return super.update(sysFunc, wrapper);
    }

    /**
     * 根据编号删除系统功能
     *
     * @param code 编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        if (this.hasChildren(code)) {
            throw new SysFuncCannotDeleteException("系统功能[" + code + "]下存在子功能，无法直接删除");
        }
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper(code);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询系统功能
     *
     * @param code 编号
     * @return 系统功能的数据传输对象
     */
    @Override
    public SysFuncDto findByCode(final String code) {
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper(code);
        final SysFunc sysFunc = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysFunc)) {
            throw new SysFuncNotFoundException("无法根据编号[" + code + "]查询到系统功能");
        }
        return sysFuncEntityConverter.entityToDto(sysFunc);
    }

    /**
     * 根据编号查询系统功能
     *
     * @param codes 编号集合
     * @return 系统功能的数据传输对象集合
     */
    @Override
    public List<SysFuncDto> findByCodes(final List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return new ArrayList<>();
        }
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper();
        final List<SysFunc> sysFuncs = super.list(wrapper.lambda().in(SysFunc::getCode, codes));
        return sysFuncEntityConverter.entityListToDtoList(sysFuncs);
    }

    /**
     * 根据条件查询系统功能并转换成树
     *
     * @param sysFuncDto 系统功能的数据传输对象树
     * @return 系统功能的数据传输对象集合
     */
    @Override
    public List<SysFuncDto> listByCondition(final SysFuncDto sysFuncDto) {
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper(sysFuncDto);
        final List<SysFunc> sysFuncs = super.list(wrapper);
        return sysFuncEntityConverter.entityListToDtoList(sysFuncs);
    }

    /**
     * 判断是否有子功能
     *
     * @param code 编号
     * @return 是否有子功能
     */
    private boolean hasChildren(final String code) {
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper();
        final List<SysFunc> sysFuncs = super.list(wrapper.lambda().eq(SysFunc::getParentCode, code));
        return CollectionUtils.isNotEmpty(sysFuncs);
    }

    /**
     * 检测系统功能名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 系统功能名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper();
        final List<SysFunc> sysFuncs = super.list(wrapper.lambda().eq(SysFunc::getName, name));
        return ExistsUtil.exists(
                sysFuncs,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysFunc> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysFunc> createQueryWrapper(final String code) {
        final QueryWrapper<SysFunc> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysFunc> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysFunc::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysFuncDto 系统功能的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysFunc> createQueryWrapper(final SysFuncDto sysFuncDto) {
        final QueryWrapper<SysFunc> wrapper = QueryWrapperUtil.createQueryWrapper(sysFuncDto);
        final SysFunc sysFunc = sysFuncEntityConverter.dtoToEntity(sysFuncDto);
        final LambdaQueryWrapper<SysFunc> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysFunc.getCode()), SysFunc::getCode, sysFunc.getCode());
        lambda.like(StringUtils.isNotBlank(sysFunc.getName()), SysFunc::getName, sysFunc.getName());
        lambda.orderByAsc(SysFunc::getSequence);
        return wrapper;
    }

    /**
     * 系统功能实体类转换接口
     */
    @Resource
    private SysFuncEntityConverter sysFuncEntityConverter;

}
