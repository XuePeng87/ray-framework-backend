package cc.xuepeng.ray.framework.facade.system.tenent.service;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.tenent.request.SysTenantRequest;
import cc.xuepeng.ray.framework.facade.system.tenent.response.SysTenantResponse;

import java.util.List;

/**
 * 系统租户的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysTenantFacade {

    /**
     * 创建系统租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysTenantRequest sysTenantRequest);

    /**
     * 修改系统租户
     *
     * @param code             系统租户编号
     * @param sysTenantRequest 系统租户的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysTenantRequest sysTenantRequest);

    /**
     * 删除系统租户
     *
     * @param code 系统租户编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据条件分页查询系统租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 系统租户的响应集合对象
     */
    PageResponse<SysTenantResponse> pageByCondition(final SysTenantRequest sysTenantRequest);

}
