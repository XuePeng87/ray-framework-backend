package cc.xuepeng.ray.framework.facade.system.dict.service;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.dict.request.SysDictItemRequest;
import cc.xuepeng.ray.framework.facade.system.dict.response.SysDictItemResponse;

/**
 * 系统字典项的业务处理门面接口
 *
 * @author xuepeng
 */
public interface SysDictItemFacade {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemRequest 系统字典项的请求对象
     * @return 是否创建成功
     */
    boolean create(final SysDictItemRequest sysDictItemRequest);

    /**
     * 修改系统字典项
     *
     * @param code             系统字典项的编号
     * @param sysDictItemRequest 系统字典项的请求对象
     * @return 是否修改成功
     */
    boolean update(final String code, final SysDictItemRequest sysDictItemRequest);

    /**
     * 删除系统字典项
     *
     * @param code 系统字典项的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统字典项
     *
     * @param code 系统字典项的编号
     * @return 系统字典项的响应对象
     */
    SysDictItemResponse findByCode(final String code);

    /**
     * 根据条件分页查询系统字典项
     *
     * @param sysDictItemRequest 系统字典项的数据请求对象
     * @return 系统字典项的响应对象集合
     */
    PageResponse<SysDictItemResponse> pageByCondition(final SysDictItemRequest sysDictItemRequest);

}
