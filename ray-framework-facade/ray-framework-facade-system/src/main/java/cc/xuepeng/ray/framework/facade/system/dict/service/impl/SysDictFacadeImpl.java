package cc.xuepeng.ray.framework.facade.system.dict.service.impl;

import cc.xuepeng.ray.framework.core.common.domain.response.PageResponse;
import cc.xuepeng.ray.framework.facade.system.dict.converter.SysDictDtoConverter;
import cc.xuepeng.ray.framework.facade.system.dict.request.SysDictRequest;
import cc.xuepeng.ray.framework.facade.system.dict.response.SysDictResponse;
import cc.xuepeng.ray.framework.facade.system.dict.service.SysDictFacade;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictDto;
import cc.xuepeng.ray.framework.module.dict.service.SysDictService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统字典的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictFacadeImpl implements SysDictFacade {

    /**
     * 创建系统字典
     *
     * @param sysDictRequest 系统字典的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDictRequest sysDictRequest) {
        final SysDictDto sysDictDto = sysDictDtoConverter.requestToDto(sysDictRequest);
        return sysDictService.create(sysDictDto);
    }

    /**
     * 修改系统字典
     *
     * @param code           系统字典的编号
     * @param sysDictRequest 系统字典的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDictRequest sysDictRequest) {
        final SysDictDto sysDictDto = sysDictDtoConverter.requestToDto(sysDictRequest);
        sysDictDto.setCode(code);
        return sysDictService.update(sysDictDto);
    }

    /**
     * 删除系统字典
     *
     * @param code 系统字典的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysDictService.delete(code);
    }

    /**
     * 根据编号查询系统字典
     *
     * @param code 系统字典的编号
     * @return 系统字典的响应对象
     */
    @Override
    public SysDictResponse findByCode(final String code) {
        final SysDictDto sysDictDto = sysDictService.findByCode(code);
        return sysDictDtoConverter.dtoToResponse(sysDictDto);
    }

    /**
     * 根据条件分页查询系统字典
     *
     * @param sysDictRequest 系统字典的数据请求对象
     * @return 系统字典的数据传输对象集合
     */
    @Override
    public PageResponse<SysDictResponse> pageByCondition(final SysDictRequest sysDictRequest) {
        final SysDictDto sysDictDto = sysDictDtoConverter.requestToDto(sysDictRequest);
        final Page<SysDictDto> sysDictDtos = sysDictService.pageByCondition(sysDictDto);
        return sysDictDtoConverter.dtoPageToResponsePage(sysDictDtos);
    }

    /**
     * 系统字典数据传输类转换接口
     */
    @Resource
    private SysDictDtoConverter sysDictDtoConverter;

    /**
     * 系统字典的业务处理接口
     */
    @Resource
    private SysDictService sysDictService;

}
