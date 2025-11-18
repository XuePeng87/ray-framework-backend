package cc.xuepeng.ray.framework.module.log.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import cc.xuepeng.ray.framework.module.log.enums.SysAuthLogType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统登录登出日志的实体类
 * 数据库表：sys_auth_log，系统登录登出日志表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysAuthLog extends BaseEntity {

    /**
     * 日志类型：1=登录日志；2=登出日志
     * 数据库字段：type,tinyint(2)
     */
    private SysAuthLogType type;

    /**
     * 登录人
     * 数据库字段：create_user,char(32)
     */
    private String createUser;

    /**
     * 登录时间
     * 数据库字段：create_time,timestamp
     */
    private LocalDateTime createTime;

    /**
     * 手机号
     * 数据库字段：phone_number,char(32)
     */
    private String phoneNumber;

    /**
     * 登录IP地址
     * 数据库字段：login_ip,varchar(32)
     */
    private String loginIp;

    /**
     * 浏览器
     * 数据库字段：browser,varchar(32)
     */
    private String browser;

    /**
     * 浏览器版本
     * 数据库字段：browser_version,varchar(32)
     */
    private String browserVersion;

    /**
     * 平台
     * 数据库字段：platfrom,varchar(128)
     */
    private String platform;

    /**
     * 操作系统
     * 数据库字段：os,varchar(32)
     */
    private String os;

    /**
     * 操作系统版本
     * 数据库字段：os_version,varchar(32)
     */
    private String osVersion;

    /**
     * 引擎
     * 数据库字段：engine,varchar(32)
     */
    private String engine;

    /**
     * 引擎版本
     * 数据库字段：engine_version,varchar(32)
     */
    private String engineVersion;

    /**
     * 操作时间
     * 数据库字段：exe_time,bigint(20)
     */
    private Long exeTime;

}
