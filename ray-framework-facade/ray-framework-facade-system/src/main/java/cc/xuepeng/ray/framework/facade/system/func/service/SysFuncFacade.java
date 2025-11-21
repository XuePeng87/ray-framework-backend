package cc.xuepeng.ray.framework.facade.system.func.service;

import cc.xuepeng.ray.framework.facade.system.func.request.SysFuncRequest;
import cc.xuepeng.ray.framework.facade.system.func.response.SysFuncResponse;

import java.util.List;

/**
 * 系统功能的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysFuncFacade {

    /**
     * 创建系统功能
     *
     * @param sysFuncRequest 系统功能的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysFuncRequest sysFuncRequest);

    /**
     * 修改系统功能
     *
     * @param code         系统功能的编号
     * @param sysFuncRequest 系统功能的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysFuncRequest sysFuncRequest);

    /**
     * 删除系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统功能
     *
     * @param code 系统功能的编号
     * @return 系统功能的响应对象
     */
    SysFuncResponse findByCode(final String code);

    /**
     * 根据条件查询系统功能
     *
     * @param sysFuncRequest 系统功能的请求对象
     * @return 系统功能的响应对象集合
     */
    List<SysFuncResponse> treeByCondition(final SysFuncRequest sysFuncRequest);

}
