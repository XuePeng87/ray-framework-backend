package cc.xuepeng.ray.framework.module.tenant.service.impl;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.tenant.converter.SysTenantEntityConverter;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import cc.xuepeng.ray.framework.module.tenant.entity.SysTenant;
import cc.xuepeng.ray.framework.module.tenant.exception.SysTenantDuplicateException;
import cc.xuepeng.ray.framework.module.tenant.exception.SysTenantNotFoundException;
import cc.xuepeng.ray.framework.module.tenant.repository.SysTenantRepository;
import cc.xuepeng.ray.framework.module.tenant.service.SysTenantService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统租户的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysTenantServiceImpl
        extends ServiceImpl<SysTenantRepository, SysTenant>
        implements SysTenantService {

    /**
     * 系统租户名称存在的异常信息
     */
    private static final String NAME_DUPLICATE_MSG = "系统租户名称[%s]已存在";

    /**
     * 系统租户电话号码存在的异常信息
     */
    private static final String PHONE_DUPLICATE_MSG = "系统租户电话号码[%s]已存在";

    /**
     * 系统租户邮箱存在的异常信息
     */
    private static final String EMAIL_DUPLICATE_MSG = "系统租户邮箱[%s]已存在";

    /**
     * 创建系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 租户编号
     */
    @Override
    @CreateUser
    public boolean create(final SysTenantDto sysTenantDto) {
        checkInfoDuplicate(0L, sysTenantDto);
        sysTenantDto.setCode(RandomUtil.get32UUID());
        final SysTenant sysTenant = sysTenantEntityConverter.dtoToEntity(sysTenantDto);
        return super.save(sysTenant);
    }

    /**
     * 修改系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final SysTenantDto sysTenantDto) {
        final SysTenantDto tenantDto = this.findByCode(sysTenantDto.getCode());
        checkInfoDuplicate(tenantDto.getId(), sysTenantDto);
        final SysTenant sysTenant = sysTenantEntityConverter.dtoToEntity(sysTenantDto);
        final QueryWrapper<SysTenant> queryWrapper = createQueryWrapper();
        queryWrapper.lambda().eq(SysTenant::getCode, sysTenant.getCode());
        return super.update(sysTenant, queryWrapper);
    }

    /**
     * 删除系统租户
     *
     * @param code 系统租户的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        final QueryWrapper<SysTenant> queryWrapper = createQueryWrapper();
        queryWrapper.lambda().eq(SysTenant::getCode, code);
        return super.remove(queryWrapper);
    }

    /**
     * 根据编号查询系统租户
     *
     * @param code 系统租户的编号
     * @return 系统租户的数据传输对象
     */
    @Override
    public SysTenantDto findByCode(final String code) {
        final QueryWrapper<SysTenant> queryWrapper = createQueryWrapper();
        queryWrapper.lambda().eq(SysTenant::getCode, code);
        final SysTenant sysTenant = super.getOne(queryWrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysTenant)) {
            throw new SysTenantNotFoundException("根据编号[" + code + "]未能查询到系统租户");
        }
        return sysTenantEntityConverter.entityToDto(sysTenant);
    }

    /**
     * 根据条件分页查询系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 系统租户的数据传输对象集合
     */
    @Override
    public Page<SysTenantDto> pageByCondition(final SysTenantDto sysTenantDto) {
        final QueryWrapper<SysTenant> wrapper = createQueryWrapper(sysTenantDto);
        final Page<SysTenant> page = PageUtil.createPage(sysTenantDto);
        final Page<SysTenant> tenants = super.page(page, wrapper);
        return sysTenantEntityConverter.entityPageToDtoPage(tenants);
    }

    /**
     * 判断系统租户名称是否存在
     *
     * @param id   系统租户的主键
     * @param name 系统租户的名称
     * @return 系统租户名称是否存在
     */
    private boolean checkNameExisted(final long id, final String name) {
        final List<SysTenant> tenants = super.list(createQueryWrapper().lambda().eq(SysTenant::getName, name));
        return ExistsUtil.exists(tenants, id == 0L ? StringUtils.EMPTY : String.valueOf(id), EntityConst.PK);
    }

    /**
     * 判断系统租户电话号码是否存在
     *
     * @param id    系统租户的主键
     * @param phoneNumber 系统租户的电话号码
     * @return 系统租户电话号码是否存在
     */
    private boolean checkPhoneExisted(final long id, final String phoneNumber) {
        final List<SysTenant> tenants = super.list(createQueryWrapper().lambda().eq(SysTenant::getPhoneNumber, phoneNumber));
        return ExistsUtil.exists(tenants, id == 0L ? StringUtils.EMPTY : String.valueOf(id), EntityConst.PK);
    }

    /**
     * 判断系统租户邮箱是否存在
     *
     * @param id    系统租户的主键
     * @param email 系统租户的邮箱
     * @return 系统租户邮箱是否存在
     */
    private boolean checkEmailExisted(final long id, final String email) {
        final List<SysTenant> tenants = super.list(createQueryWrapper().lambda().eq(SysTenant::getEmail, email));
        return ExistsUtil.exists(tenants, id == 0L ? StringUtils.EMPTY : String.valueOf(id), EntityConst.PK);
    }

    /**
     * 验证系统租户的名称、电话和邮箱是否已经注册
     *
     * @param id           系统租户的主键
     * @param sysTenantDto 系统租户的数据传输对象
     */
    private void checkInfoDuplicate(final long id, final SysTenantDto sysTenantDto) {
        // 验证租户名称、电话、邮箱是否已被注册
        if (checkNameExisted(id, sysTenantDto.getName())) {
            throw new SysTenantDuplicateException(String.format(NAME_DUPLICATE_MSG, sysTenantDto.getName()));
        }
        if (checkPhoneExisted(id, sysTenantDto.getPhoneNumber())) {
            throw new SysTenantDuplicateException(String.format(PHONE_DUPLICATE_MSG, sysTenantDto.getPhoneNumber()));
        }
        if (checkEmailExisted(id, sysTenantDto.getEmail())) {
            throw new SysTenantDuplicateException(String.format(EMAIL_DUPLICATE_MSG, sysTenantDto.getEmail()));
        }
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysTenant> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysTenantDto 系统租户数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysTenant> createQueryWrapper(final SysTenantDto sysTenantDto) {
        final SysTenant sysTenant = sysTenantEntityConverter.dtoToEntity(sysTenantDto);
        final QueryWrapper<SysTenant> wrapper = QueryWrapperUtil.createQueryWrapper(sysTenantDto);
        final LambdaQueryWrapper<SysTenant> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysTenantDto.getCode()), SysTenant::getCode, sysTenant.getCode());
        lambda.like(StringUtils.isNotBlank(sysTenant.getName()), SysTenant::getName, sysTenant.getName());
        lambda.like(StringUtils.isNotBlank(sysTenant.getPhoneNumber()), SysTenant::getPhoneNumber, sysTenant.getPhoneNumber());
        lambda.like(StringUtils.isNotBlank(sysTenant.getEmail()), SysTenant::getEmail, sysTenant.getEmail());
        lambda.ge(ObjectUtils.isNotEmpty(sysTenantDto.getBeginExpireTime()), SysTenant::getExpireTime, sysTenantDto.getBeginExpireTime());
        lambda.le(ObjectUtils.isNotEmpty(sysTenantDto.getEndExpireTime()), SysTenant::getExpireTime, sysTenantDto.getEndExpireTime());
        return wrapper;
    }

    /**
     * 系统租户对象转换接口
     */
    @Resource
    private SysTenantEntityConverter sysTenantEntityConverter;

}
