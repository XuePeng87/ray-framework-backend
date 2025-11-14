package cc.xuepeng.ray.framework.module.system.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import lombok.*;

/**
 * 系统字的典实体类
 * 数据库表：sys_dict，系统字典表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDict extends BizEntity {

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
     * 描述
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
