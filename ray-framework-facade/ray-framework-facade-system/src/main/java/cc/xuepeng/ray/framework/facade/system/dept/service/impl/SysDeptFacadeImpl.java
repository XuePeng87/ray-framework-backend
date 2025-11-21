package cc.xuepeng.ray.framework.facade.system.dept.service.impl;

import cc.xuepeng.ray.framework.facade.system.dept.converter.SysDeptDtoConverter;
import cc.xuepeng.ray.framework.facade.system.dept.request.SysDeptRequest;
import cc.xuepeng.ray.framework.facade.system.dept.response.SysDeptResponse;
import cc.xuepeng.ray.framework.facade.system.dept.service.SysDeptFacade;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import cc.xuepeng.ray.framework.module.dept.service.SysDeptService;
import cc.xuepeng.ray.framework.module.dept.decorator.SysDeptFormat;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统部门的业务处理门面实现类
 *
 * @author xuepeng
 */
@Component
public class SysDeptFacadeImpl implements SysDeptFacade {

    /**
     * 创建系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否创建成功
     */
    @Override
    public boolean create(final SysDeptRequest sysDeptRequest) {
        final SysDeptDto sysDeptDto = sysDeptDtoConverter.requestToDto(sysDeptRequest);
        return sysDeptService.create(sysDeptDto);
    }

    /**
     * 修改系统部门
     *
     * @param code         系统部门的编号
     * @param sysDeptRequest 系统部门的请求对象
     * @return 是否修改成功
     */
    @Override
    public boolean update(final String code, final SysDeptRequest sysDeptRequest) {
        final SysDeptDto sysDeptDto = sysDeptDtoConverter.requestToDto(sysDeptRequest);
        sysDeptDto.setCode(code);
        return sysDeptService.update(sysDeptDto);
    }

    /**
     * 删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    @Override
    public boolean delete(final String code) {
        return sysDeptService.delete(code);
    }

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的响应对象
     */
    @Override
    public SysDeptResponse findByCode(final String code) {
        final SysDeptDto sysDeptDto = sysDeptService.findByCode(code);
        return sysDeptDtoConverter.dtoToResponse(sysDeptDto);
    }

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptRequest 系统部门的请求对象
     * @return 系统部门的响应对象集合
     */
    @Override
    public List<SysDeptResponse> treeByCondition(final SysDeptRequest sysDeptRequest) {
        final SysDeptDto sysDeptDto = sysDeptDtoConverter.requestToDto(sysDeptRequest);
        final List<SysDeptDto> sysDeptDtos = sysDeptService.listByCondition(sysDeptDto);
        return sysDeptDtoConverter.dtoListToResponseList(sysDeptFormat.tree(sysDeptDtos));
    }

    /**
     * 系统部门数据传输类转换接口
     */
    @Resource
    private SysDeptDtoConverter sysDeptDtoConverter;

    /**
     * 系统部门的业务处理接口
     */
    @Resource
    private SysDeptService sysDeptService;

    /**
     * 系统部门的格式化接口
     */
    @Resource
    private SysDeptFormat sysDeptFormat;

}
