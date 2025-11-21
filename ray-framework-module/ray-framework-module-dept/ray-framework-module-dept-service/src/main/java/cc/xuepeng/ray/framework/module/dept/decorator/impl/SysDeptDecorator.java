package cc.xuepeng.ray.framework.module.dept.decorator.impl;

import cc.xuepeng.ray.framework.module.dept.decorator.SysDeptFormat;
import cc.xuepeng.ray.framework.module.dept.dto.SysDeptDto;

import java.util.List;

/**
 * 系统部门格式化类的装饰者
 *
 * @author xuepeng
 */
public abstract class SysDeptDecorator implements SysDeptFormat {

    /**
     * 系统部门格式化接口
     */
    final SysDeptFormat sysDeptFormat;

    /**
     * 构造函数
     *
     * @param sysDeptFormat 系统部门格式化接口
     */
    protected SysDeptDecorator(SysDeptFormat sysDeptFormat) {
        this.sysDeptFormat = sysDeptFormat;
    }

    /**
     * 将系统部门格式化成树结构
     *
     * @param sysDeptDtos 系统部门的数据传输对象集合
     * @return 系统部门的数据传输对象集合
     */
    @Override
    public List<SysDeptDto> tree(final List<SysDeptDto> sysDeptDtos) {
        return sysDeptFormat.tree(sysDeptDtos);
    }

}
