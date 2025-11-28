package cc.xuepeng.ray.framework.facade.system.tenent.service.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.tenent.converter.SysTenantDtoConverter;
import cc.xuepeng.ray.framework.facade.system.tenent.request.SysTenantRequest;
import cc.xuepeng.ray.framework.facade.system.tenent.response.SysTenantResponse;
import cc.xuepeng.ray.framework.facade.system.tenent.service.SysTenantFacade;
import cc.xuepeng.ray.framework.module.tenant.dto.SysTenantDto;
import cc.xuepeng.ray.framework.module.tenant.service.SysTenantService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统租户的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysTenantFacadeImpl implements SysTenantFacade {

    /**     * 创建租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysTenantRequest sysTenantRequest) {
        final SysTenantDto sysTenantDto = sysTenantDtoConverter.requestToDto(sysTenantRequest);
        return sysTenantService.create(sysTenantDto);
    }

    /**
     * 修改租户
     *
     * @param code             系统租户编号
     * @param sysTenantRequest 系统租户的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysTenantRequest sysTenantRequest) {
        final SysTenantDto sysTenantDto = sysTenantDtoConverter.requestToDto(sysTenantRequest);
        sysTenantDto.setCode(code);
        return sysTenantService.update(sysTenantDto);
    }

    /**
     * 删除租户
     *
     * @param code 系统租户编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysTenantService.delete(code);
    }

    /**
     * 根据条件分页查询系统租户
     *
     * @param sysTenantRequest 系统租户的请求对象
     * @return 系统租户的相应对象集合
     */
    @Override
    public PageResponse<SysTenantResponse> pageByCondition(final SysTenantRequest sysTenantRequest) {
        final SysTenantDto sysTenantDto = sysTenantDtoConverter.requestToDto(sysTenantRequest);
        final Page<SysTenantDto> tenantDtos = sysTenantService.pageByCondition(sysTenantDto);
        return sysTenantDtoConverter.dtoPageToResponsePage(tenantDtos);
    }

    /**
     * 系统租户数据传输类转换接口
     */
    @Resource
    private SysTenantDtoConverter sysTenantDtoConverter;

    /**
     * 系统租户的业务处理接口
     */
    @Resource
    private SysTenantService sysTenantService;

}
