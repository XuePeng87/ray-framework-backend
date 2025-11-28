package cc.xuepeng.ray.framework.module.func.decorator.impl;

import cc.xuepeng.ray.framework.core.common.util.TreeUtil;
import cc.xuepeng.ray.framework.module.func.decorator.SysFuncFormat;
import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统功能格式化类
 *
 * @author xuepeng
 */
@Component
public class SysFuncDefaultFormat implements SysFuncFormat {

    /**
     * 将系统功能格式化成树结构
     *
     * @param sysFuncDtos 系统功能的数据传输对象集合
     * @return 系统功能的数据传输对象集合
     */
    @Override
    public List<SysFuncDto> tree(final List<SysFuncDto> sysFuncDtos) {
        return TreeUtil.format(sysFuncDtos);
    }

}
