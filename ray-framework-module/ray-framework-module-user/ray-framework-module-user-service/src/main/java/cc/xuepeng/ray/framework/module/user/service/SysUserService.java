package cc.xuepeng.ray.framework.module.user.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cc.xuepeng.ray.framework.module.user.dto.SysUserDto;

import java.util.List;

/**
 * 系统用户的业务处理接口
 *
 * @author xuepeng
 */
public interface SysUserService {

    /**
     * 创建系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysUserDto sysUserDto);

    /**
     * 修改系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysUserDto sysUserDto);

    /**
     * 根据编号删除系统用户
     *
     * @param code 编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统用户
     *
     * @param code 编号
     * @return 系统用户的数据传输对象
     */
    SysUserDto findByCode(final String code);

    /**
     * 根据编号查询系统用户
     *
     * @param codes 编号集合
     * @return 系统用户的数据传输对象集合
     */
    List<SysUserDto> findByCodes(final List<String> codes);

    /**
     * 根据手机号码和密码查找系统用户
     *
     * @param phoneNumber 手机号码
     * @param password    密码
     * @return 系统用户的数据传输对象
     */
    SysUserDto findByPhoneNumberAndPassword(final String phoneNumber, final String password);

    /**
     * 根据条件查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    List<SysUserDto> listByCondition(final SysUserDto sysUserDto);

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserDto 系统用户的数据传输对象
     * @return 系统用户的数据传输对象集合
     */
    Page<SysUserDto> pageByCondition(final SysUserDto sysUserDto);

    /**
     * 根据编号重置密码
     *
     * @param code 编号
     * @return 是否重置成功
     */
    boolean resetPassword(final String code);

}
