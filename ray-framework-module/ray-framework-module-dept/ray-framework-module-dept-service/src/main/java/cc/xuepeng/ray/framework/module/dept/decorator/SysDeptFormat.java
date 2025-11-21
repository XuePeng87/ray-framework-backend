package cc.xuepeng.ray.framework.module.dept.decorator;

import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;

import java.util.List;

/**
 * 系统部门格式化接口
 *
 * @author xuepeng
 */
public interface SysDeptFormat {

    /**
     * 将系统部门格式化成树结构
     *
     * @param sysDeptDtos 系统部门的数据传输对象集合
     * @return 系统部门的数据传输对象集合
     */
    List<SysDeptDto> tree(final List<SysDeptDto> sysDeptDtos);

}
