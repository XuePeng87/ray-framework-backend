package cc.xuepeng.ray.framework.facade.system.user.service;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.user.request.SysUserRequest;
import cc.xuepeng.ray.framework.facade.system.user.response.SysUserResponse;

/**
 * 系统用户的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysUserFacade {

    /**
     * 创建系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysUserRequest sysUserRequest);

    /**
     * 修改系统用户
     *
     * @param code         系统用户的编号
     * @param sysUserRequest 系统用户的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysUserRequest sysUserRequest);

    /**
     * 删除系统用户
     *
     * @param code 系统用户的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统用户
     *
     * @param code 系统用户的编号
     * @return 系统用户的响应对象
     */
    SysUserResponse findByCode(final String code);

    /**
     * 根据条件分页查询系统用户
     *
     * @param sysUserRequest 系统用户的请求对象
     * @return 系统用户的响应对象
     */
    PageResponse<SysUserResponse> pageByCondition(final SysUserRequest sysUserRequest);

    /**
     * 根据编号重置密码
     *
     * @param code 编号
     * @return 是否重置成功
     */
    boolean resetPassword(final String code);

}
