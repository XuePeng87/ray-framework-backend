package cc.xuepeng.ray.framework.module.dept.decorator.impl;

import cc.xuepeng.ray.framework.core.common.util.TreeUtil;
import cc.xuepeng.ray.framework.module.dept.decorator.SysDeptFormat;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统部门格式化类
 *
 * @author xuepeng
 */
@Component
public class SysDeptDefaultFormat implements SysDeptFormat {

    /**
     * 将系统部门格式化成树结构
     *
     * @param sysDeptDtos 系统部门的数据传输对象集合
     * @return 系统部门的数据传输对象集合
     */
    @Override
    public List<SysDeptDto> tree(final List<SysDeptDto> sysDeptDtos) {
        return TreeUtil.format(sysDeptDtos);
    }

}
