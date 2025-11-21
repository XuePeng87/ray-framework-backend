package cc.xuepeng.ray.framework.module.user.service.impl;

import cc.xuepeng.ray.framework.core.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser;
import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.user.converter.SysUserEntityConverter;
import cc.xuepeng.ray.framework.module.user.entity.SysUser;
import cc.xuepeng.ray.framework.module.user.exception.SysUserDuplicateException;
import cc.xuepeng.ray.framework.module.user.exception.SysUserNotFoundException;
import cc.xuepeng.ray.framework.module.user.repository.SysUserRepository;
import cc.xuepeng.ray.framework.module.user.service.SysUserService;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ray.framework.module.user.dto.SysUserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统用户的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysUserServiceImpl
        extends ServiceImpl<SysUserRepository, SysUser>
        implements SysUserService {

    /**
     * 创建系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    @Transactional(rollbackFor = Exception.class)
    public boolean create(final SysUserDto sysUserDto) {
        final String phoneNumber = sysUserDto.getPhoneNumber();
        final String email = sysUserDto.getEmail();
        if (this.checkPhoneNumberExisted(StringUtils.EMPTY, phoneNumber)) {
            throw new SysUserDuplicateException("系统用户手机号码[" + phoneNumber + "]已存在");
        }
        if (this.checkEmailExisted(StringUtils.EMPTY, email)) {
            throw new SysUserDuplicateException("系统用户邮箱[" + email + "]已存在");
        }
        sysUserDto.setCode(RandomUtil.get32UUID());
        sysUserDto.setPassword(DigestUtil.md5Hex("000000"));
        final SysUser sysUser = sysUserEntityConverter.dtoToEntity(sysUserDto);
        return super.save(sysUser);
    }

    /**
     * 修改系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final SysUserDto sysUserDto) {
        final String code = sysUserDto.getCode();
        final String phoneNumber = sysUserDto.getPhoneNumber();
        final String email = sysUserDto.getEmail();
        if (this.checkPhoneNumberExisted(code, phoneNumber)) {
            throw new SysUserDuplicateException("系统用户手机号码[" + phoneNumber + "]已存在");
        }
        if (this.checkEmailExisted(code, email)) {
            throw new SysUserDuplicateException("系统用户邮箱[" + email + "]已存在");
        }
        final SysUser sysUser = sysUserEntityConverter.dtoToEntity(sysUserDto);
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(code);
        return super.update(sysUser, wrapper);
    }

    /**
     * 根据编号删除系统用户
     *
     * @param code 编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(code);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询系统用户
     *
     * @param code 编号
     * @return 系统用户的数据传输对象
     */
    @Override
    public SysUserDto findByCode(final String code) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(code);
        final SysUser sysUser = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new SysUserNotFoundException("无法根据编号[" + code + "]查询到系统用户");
        }
        return sysUserEntityConverter.entityToDto(sysUser);
    }

    /**
     * 根据编号查询系统用户
     *
     * @param codes 编号集合
     * @return 系统用户的数据传输对象集合
     */
    @Override
    public List<SysUserDto> findByCodes(final List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return new ArrayList<>();
        }
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        final List<SysUser> sysUsers = super.list(wrapper.lambda().in(SysUser::getCode, codes));
        return sysUserEntityConverter.entityListToDtoList(sysUsers);
    }

    /**
     * 根据手机号码和密码查找系统用户
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return 系统用户的数据传输对象
     */
    @Override
    public SysUserDto findByPhoneNumberAndPassword(final String phoneNumber, final String password) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        wrapper.lambda()
                .eq(SysUser::getPhoneNumber, phoneNumber)
                .eq(SysUser::getPassword, DigestUtil.md5Hex(password));
        final SysUser sysUser = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysUser)) {
            throw new SysUserNotFoundException("无法根据手机号码和密码查询到系统用户");
        }
        return sysUserEntityConverter.entityToDto(sysUser);
    }

    /**
     * 根据条件查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    @Override
    public List<SysUserDto> listByCondition(final SysUserDto sysUserDto) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(sysUserDto);
        final List<SysUser> sysUsers = super.list(wrapper);
        return sysUserEntityConverter.entityListToDtoList(sysUsers);
    }

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    @Override
    public Page<SysUserDto> pageByCondition(final SysUserDto sysUserDto) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(sysUserDto);
        final Page<SysUser> page = PageUtil.createPage(sysUserDto);
        final Page<SysUser> sysUsers = super.page(page, wrapper);
        return sysUserEntityConverter.entityPageToDtoPage(sysUsers);
    }

    /**
     * 根据编号重置密码
     *
     * @param code 编号
     * @return 是否重置成功
     */
    @Override
    public boolean resetPassword(final String code) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper(code);
        final SysUser sysUser = new SysUser();
        sysUser.setPassword(DigestUtil.md5Hex("000000"));
        return super.update(sysUser, wrapper);
    }

    /**
     * 检测系统用户功能手机号码是否已存在
     *
     * @param code        编号
     * @param phoneNumber 功能手机号码
     * @return 系统用户功能手机号码是否已存在
     */
    private boolean checkPhoneNumberExisted(final String code, final String phoneNumber) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        final List<SysUser> sysUsers = super.list(wrapper.lambda().eq(SysUser::getPhoneNumber, phoneNumber));
        return ExistsUtil.exists(
                sysUsers,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * 检测系统用户邮箱是否已存在
     *
     * @param code  编号
     * @param email 邮箱
     * @return 系统用户邮箱是否已存在
     */
    private boolean checkEmailExisted(final String code, final String email) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        final List<SysUser> sysUsers = super.list(wrapper.lambda().eq(SysUser::getEmail, email));
        return ExistsUtil.exists(
                sysUsers,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysUser> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysUser> createQueryWrapper(final String code) {
        final QueryWrapper<SysUser> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysUser::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysUser> createQueryWrapper(final SysUserDto sysUserDto) {
        final QueryWrapper<SysUser> wrapper = QueryWrapperUtil.createQueryWrapper(sysUserDto);
        final SysUser sysUser = sysUserEntityConverter.dtoToEntity(sysUserDto);
        final LambdaQueryWrapper<SysUser> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysUser.getCode()), SysUser::getCode, sysUser.getCode());
        lambda.eq(StringUtils.isNotBlank(sysUser.getDeptCode()), SysUser::getDeptCode, sysUser.getDeptCode());
        lambda.like(StringUtils.isNotBlank(sysUser.getName()), SysUser::getName, sysUser.getName());
        lambda.like(StringUtils.isNotBlank(sysUser.getPhoneNumber()), SysUser::getPhoneNumber, sysUser.getPhoneNumber());
        return wrapper;
    }

    /**
     * 系统用户对象转换接口
     */
    @Resource
    private SysUserEntityConverter sysUserEntityConverter;

}
