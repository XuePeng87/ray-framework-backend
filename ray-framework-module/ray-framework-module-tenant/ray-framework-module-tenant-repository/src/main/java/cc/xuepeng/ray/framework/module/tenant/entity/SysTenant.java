package cc.xuepeng.ray.framework.module.tenant.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统租户的实体类
 * 数据库表：sys_tenant，系统租户表
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysTenant extends BizEntity {

    /**
     * 编号
     * 数据库字段：code，char(32)
     */
    private String code;

    /**
     * 名称
     * 数据库字段：name，varchar(128)
     */
    private String name;

    /**
     * 手机
     * 数据库字段：phone_number，varchar(32)
     */
    private String phoneNumber;

    /**
     * 邮箱
     * 数据库字段：email，varchar(128)
     */
    private String email;

    /**
     * 状态：0=停用；1=启用
     * 数据库字段：status，tinyint(2)
     */
    private BizStatus status;

    /**
     * 有效期
     * 数据库字段：expire_time，timestamp
     */
    private LocalDateTime expireTime;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
