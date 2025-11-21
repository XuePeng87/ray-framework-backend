package cc.xuepeng.ray.framework.facade.system.dept.service;

import cc.xuepeng.ray.framework.facade.system.dept.request.SysDeptRequest;
import cc.xuepeng.ray.framework.facade.system.dept.response.SysDeptResponse;

import java.util.List;

/**
 * 系统部门的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysDeptFacade {

    /**
     * 创建系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysDeptRequest sysDeptRequest);

    /**
     * 修改系统部门
     *
     * @param code         系统部门的编号
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysDeptRequest sysDeptRequest);

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    SysDeptResponse findByCode(final String code);

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    List<SysDeptResponse> treeByCondition(final SysDeptRequest sysDeptRequest);

}
