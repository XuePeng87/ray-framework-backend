package cc.xuepeng.ray.framework.module.func.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.common.strategy.composite.Composite;
import cc.xuepeng.ray.framework.module.func.enums.SysFuncTypeDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncDto extends BaseDto implements Composite {

    /**
     * 父级编号
     */
    private String parentCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 类型：0=目录，1=功能；2=按钮；3=外链
     */
    private SysFuncTypeDto type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 是否外链
     */
    private Boolean linkable;

    /**
     * 是否缓存
     */
    private Boolean cacheable;

    /**
     * 是否可见
     */
    private Boolean visible;

    /**
     * 始终显示根菜单
     */
    private Boolean alwaysShow;

    /**
     * 组件权限
     */
    private String permission;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子功能
     */
    private List<SysFuncDto> children = new ArrayList<>();

    /**
     * @return 获取主键
     */
    @Override
    public String getNodeId() {
        return this.getCode();
    }

    /**
     * @return 获取名称
     */
    @Override
    public String getNodeName() {
        return this.name;
    }

    /**
     * @return 获取父级主键
     */
    @Override
    public String getNodePid() {
        return this.parentCode;
    }

    /**
     * 添加到子级
     *
     * @param composite 组合对象
     */
    @Override
    public void add(final Composite composite) {
        this.children.add((SysFuncDto) composite);
    }

    /**
     * 移除子级
     *
     * @param index 组合对象索引
     */
    @Override
    public void remove(final int index) {
        this.children.remove(index);
    }

}
