package cc.xuepeng.ray.framework.module.tenant.service;

import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 系统租户的业务处理接口
 *
 * @author xuepeng
 */
public interface SysTenantService {

    /**
     * 创建系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysTenantDto sysTenantDto);

    /**
     * 修改系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysTenantDto sysTenantDto);

    /**
     * 删除系统租户
     *
     * @param code 系统租户的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统租户
     *
     * @param code 系统租户的编号
     * @return 系统租户的数据传输对象
     */
    SysTenantDto findByCode(final String code);

    /**
     * 根据条件分页查询系统租户
     *
     * @param sysTenantDto 系统租户的数据传输对象
     * @return 系统租户的数据传输对象集合
     */
    Page<SysTenantDto> pageByCondition(final SysTenantDto sysTenantDto);

}
