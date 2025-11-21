package cc.xuepeng.ray.framework.facade.system.dict.service.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.dict.converter.SysDictItemDtoConverter;
import cc.xuepeng.ray.framework.facade.system.dict.request.SysDictItemRequest;
import cc.xuepeng.ray.framework.facade.system.dict.response.SysDictItemResponse;
import cc.xuepeng.ray.framework.facade.system.dict.service.SysDictItemFacade;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.dict.service.SysDictItemService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统字典项的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictItemFacadeImpl implements SysDictItemFacade {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemRequest 系统字典项的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDictItemRequest sysDictItemRequest) {
        final SysDictItemDto sysDictItemDto = sysDictItemDtoConverter.requestToDto(sysDictItemRequest);
        return sysDictItemService.create(sysDictItemDto);
    }

    /**
     * 修改系统字典项
     *
     * @param code             系统字典项的编号
     * @param sysDictItemRequest 系统字典项的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDictItemRequest sysDictItemRequest) {
        final SysDictItemDto sysDictItemDto = sysDictItemDtoConverter.requestToDto(sysDictItemRequest);
        sysDictItemDto.setCode(code);
        return sysDictItemService.update(sysDictItemDto);
    }

    /**
     * 删除系统字典项
     *
     * @param codes 系统字典项的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final List<String> codes) {
        return sysDictItemService.deleteByCodes(codes);
    }

    /**
     * 根据编号查询系统字典项
     *
     * @param code 系统字典项的编号
     * @return 系统字典项的响应对象
     */
    @Override
    public SysDictItemResponse findByCode(final String code) {
        final SysDictItemDto sysDictItemDto = sysDictItemService.findByCode(code);
        return sysDictItemDtoConverter.dtoToResponse(sysDictItemDto);
    }

    /**
     * 根据条件分页查询系统字典项
     *
     * @param sysDictItemRequest 系统字典项的数据请求对象
     * @return 系统字典项的响应对象集合
     */
    @Override
    public PageResponse<SysDictItemResponse> pageByCondition(final SysDictItemRequest sysDictItemRequest) {
        final SysDictItemDto sysDictItemDto = sysDictItemDtoConverter.requestToDto(sysDictItemRequest);
        final Page<SysDictItemDto> sysDictItemDtos = sysDictItemService.pageByCondition(sysDictItemDto);
        return sysDictItemDtoConverter.dtoPageToResponsePage(sysDictItemDtos);
    }

    /**
     * 系统字典项数据传输类转换接口
     */
    @Resource
    private SysDictItemDtoConverter sysDictItemDtoConverter;

    /**
     * 系统字典项的业务处理接口
     */
    @Resource
    private SysDictItemService sysDictItemService;

}
