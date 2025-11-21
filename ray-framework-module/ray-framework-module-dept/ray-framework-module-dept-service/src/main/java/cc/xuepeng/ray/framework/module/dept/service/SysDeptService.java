package cc.xuepeng.ray.framework.module.dept.service;

import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;

import java.util.List;

/**
 * 系统部门的业务处理接口
 *
 * @author xuepeng
 */
public interface SysDeptService {

    /**
     * 创建系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysDeptDto sysDeptDto);

    /**
     * 修改系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysDeptDto sysDeptDto);

    /**
     * 根据编号删除系统部门
     *
     * @param code 系统部门的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统部门
     *
     * @param code 系统部门的编号
     * @return 系统部门的数据传输对象
     */
    SysDeptDto findByCode(final String code);

    /**
     * 根据条件查询系统部门
     *
     * @param sysDeptDto 系统部门的数据传输对象
     * @return 系统部门的数据传输对象集合
     */
    List<SysDeptDto> listByCondition(final SysDeptDto sysDeptDto);

}
