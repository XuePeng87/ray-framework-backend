package cc.xuepeng.ray.framework.module.dept.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import cc.xuepeng.ray.framework.core.common.strategy.composite.Composite;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统部门的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDeptDto extends BaseDto implements Composite {

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 父级编号
     */
    private String parentCode;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子部门
     */
    private List<SysDeptDto> children = new ArrayList<>();

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
        this.children.add((SysDeptDto) composite);
    }

    /**
     * 移除子级
     *
     * @param index 组合对象索引
     */
    @Override
    public void remove(int index) {
        this.children.remove(index);
    }

}
