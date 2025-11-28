package cc.xuepeng.ray.framework.module.func.decorator.impl;

import cc.xuepeng.ray.framework.module.func.decorator.SysFuncFormat;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;

import java.util.List;

/**
 * 系统功能格式化类的装饰者
 *
 * @author xuepeng
 */
public abstract class SysFuncDecorator implements SysFuncFormat {

    /**
     * 系统功能格式化接口
     */
    final SysFuncFormat sysFuncFormat;

    /**
     * 构造函数
     *
     * @param sysFuncFormat 系统功能格式化接口
     */
    protected SysFuncDecorator(SysFuncFormat sysFuncFormat) {
        this.sysFuncFormat = sysFuncFormat;
    }

    /**
     * 将系统功能格式化成树结构
     *
     * @param sysFuncDtos 系统功能的数据传输对象集合
     * @return 系统功能的数据传输对象集合
     */
    @Override
    public List<SysFuncDto> tree(final List<SysFuncDto> sysFuncDtos) {
        return sysFuncFormat.tree(sysFuncDtos);
    }

}
