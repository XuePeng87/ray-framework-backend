package cc.xuepeng.ray.framework.module.dict.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import lombok.*;

/**
 * 系统字典项的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItemDto extends BaseDto {

    /**
     * 所属字典
     */
    private String dictValue;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典值
     */
    private String value;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 描述
     */
    private String remark;

}
