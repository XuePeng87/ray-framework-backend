package cc.xuepeng.ray.framework.facade.system.func.service.impl;

import cc.xuepeng.ray.framework.core.common.util.TreeUtil;
import cc.xuepeng.ray.framework.facade.system.func.converter.SysFuncDtoConverter;
import cc.xuepeng.ray.framework.facade.system.func.request.SysFuncRequest;
import cc.xuepeng.ray.framework.facade.system.func.response.SysFuncResponse;
import cc.xuepeng.ray.framework.facade.system.func.service.SysFuncFacade;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import cc.xuepeng.ray.framework.module.func.service.SysFuncService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统功能的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysFuncFacadeImpl implements SysFuncFacade {

    /**
     * 创建系统功能
     *
     * @param sysFuncRequest 系统功能的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysFuncRequest sysFuncRequest) {
        final SysFuncDto sysFuncDto = sysFuncDtoConverter.requestToDto(sysFuncRequest);
        return sysFuncService.create(sysFuncDto);
    }

    /**
     * 修改系统功能
     *
     * @param code         系统功能的编号
     * @param sysFuncRequest 系统功能的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysFuncRequest sysFuncRequest) {
        final SysFuncDto sysFuncDto = sysFuncDtoConverter.requestToDto(sysFuncRequest);
        sysFuncDto.setCode(code);
        return sysFuncService.update(sysFuncDto);
    }

    /**
     * 删除系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysFuncService.delete(code);
    }

    /**
     * 根据编号查询系统功能
     *
     * @param code 系统功能的编号
     * @return 是否删除成功
     */
    @Override
    public SysFuncResponse findByCode(final String code) {
        final SysFuncDto sysFuncDto = sysFuncService.findByCode(code);
        return sysFuncDtoConverter.dtoToResponse(sysFuncDto);
    }

    /**
     * 根据条件查询系统功能
     *
     * @param sysFuncRequest 系统功能的请求对象
     * @return 系统功能的响应对象集合
     */
    @Override
    public List<SysFuncResponse> treeByCondition(final SysFuncRequest sysFuncRequest) {
        final SysFuncDto sysFuncDto = sysFuncDtoConverter.requestToDto(sysFuncRequest);
        final List<SysFuncDto> sysFuncDtoList = sysFuncService.listByCondition(sysFuncDto);
        return sysFuncDtoConverter.dtoListToResponseList(TreeUtil.format(sysFuncDtoList));
    }

    /**
     * 系统功能数据传输类转换接口
     */
    @Resource
    private SysFuncDtoConverter sysFuncDtoConverter;

    /**
     * 系统功能的业务处理接口
     */
    @Resource
    private SysFuncService sysFuncService;

}
