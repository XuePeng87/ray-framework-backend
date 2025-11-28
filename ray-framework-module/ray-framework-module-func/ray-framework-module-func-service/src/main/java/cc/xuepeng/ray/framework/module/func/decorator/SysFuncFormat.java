package cc.xuepeng.ray.framework.module.func.decorator;

import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;

import java.util.List;

/**
 * 系统功能格式化接口
 *
 * @author xuepeng
 */
public interface SysFuncFormat {

    /**
     * 将系统功能格式化成树结构
     *
     * @param sysFuncDtos 系统功能的数据传输对象集合
     * @return 系统功能的数据传输对象集合
     */
    List<SysFuncDto> tree(final List<SysFuncDto> sysFuncDtos);

}
