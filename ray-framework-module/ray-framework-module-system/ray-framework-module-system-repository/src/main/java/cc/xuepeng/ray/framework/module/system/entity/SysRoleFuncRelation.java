package cc.xuepeng.ray.framework.module.system.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import lombok.*;

/**
 * 系统角色与系统功能关系的实体类
 * 数据库表：sys_role_func_relation，系统角色与系统功能的关系表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRoleFuncRelation extends BaseEntity {

    /**
     * 角色编号
     * 数据库字段：role_code，char(32)
     */
    private String roleCode;

    /**
     * 功能编号
     * 数据库字段：func_code，char(32)
     */
    private String funcCode;

}
