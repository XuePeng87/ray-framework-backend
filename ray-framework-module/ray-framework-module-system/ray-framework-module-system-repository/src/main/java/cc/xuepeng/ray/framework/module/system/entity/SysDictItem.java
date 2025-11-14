package cc.xuepeng.ray.framework.module.system.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import lombok.*;

/**
 * 系统字典项的实体类
 * 数据库表：sys_dict_item，系统字典项表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItem extends BizEntity {

    /**
     * 所属字典
     * 数据库字段：dict_value，varchar(16)
     */
    private String dictValue;

    /**
     * 编号
     * 数据库字段：code，char(32)
     */
    private String code;

    /**
     * 名称
     * 数据库字段：name，varchar(16)
     */
    private String name;

    /**
     * 字典值
     * 数据库字段：value，varchar(16)
     */
    private String value;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：status，tinyint(1)
     */
    private BizStatus status;

    /**
     * 排序
     * 数据库字段：sequence，int(11)
     */
    private Integer sequence;

    /**
     * 描述
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
