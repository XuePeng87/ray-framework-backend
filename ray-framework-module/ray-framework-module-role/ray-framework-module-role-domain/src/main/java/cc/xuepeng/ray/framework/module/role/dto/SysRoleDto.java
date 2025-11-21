package cc.xuepeng.ray.framework.module.role.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import lombok.*;

/**
 * 系统角色的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRoleDto extends BaseDto {

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

}
