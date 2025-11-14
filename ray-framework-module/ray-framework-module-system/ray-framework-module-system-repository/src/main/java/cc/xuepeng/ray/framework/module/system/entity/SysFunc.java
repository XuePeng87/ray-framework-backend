package cc.xuepeng.ray.framework.module.system.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BizEntity;
import cc.xuepeng.ray.framework.module.system.enums.SysFuncType;
import lombok.*;

/**
 * 系统功能的实体类
 * 数据库表：sys_func，系统功能表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFunc extends BizEntity {

    /**
     * 父级编号
     * 数据库字段：parent_code，char(32)
     */
    private String parentCode;

    /**
     * 编号
     * 数据库字段：code，varchar(32)
     */
    private String code;

    /**
     * 名称
     * 数据库字段：name，varchar(32)
     */
    private String name;

    /**
     * 类型：0=目录，1=功能；2=按钮；3=外链
     * 数据库字段：type，tinyint(2)
     */
    private SysFuncType type;

    /**
     * 图标
     * 数据库字段：icon，varchar(32)
     */
    private String icon;

    /**
     * 路由地址
     * 数据库字段：path，varchar(256)
     */
    private String path;

    /**
     * 重定向地址
     * 数据库字段：redirect，varchar(128)
     */
    private String redirect;

    /**
     * 是否外链
     * 数据库字段：linkable，tinyint(1)
     */
    private Boolean linkable;

    /**
     * 是否缓存
     * 数据库字段：cacheable，tinyint(1)
     */
    private Boolean cacheable;

    /**
     * 是否可见
     * 数据库字段：visible，tinyint(1)
     */
    private Boolean visible;

    /**
     * 始终显示根菜单
     * 数据库字段：always_show，tinyint(1)
     */
    private Boolean alwaysShow;

    /**
     * 组件权限
     * 数据库字段：permission，varchar(64)
     */
    private String permission;

    /**
     * 组件地址
     * 数据库字段：component_path，varchar(256)
     */
    private String component;

    /**
     * 排序
     * 数据库字段：sequence，int(11)
     */
    private Integer sequence;

    /**
     * 备注
     * 数据库字段：remark，varchar(256)
     */
    private String remark;

}
