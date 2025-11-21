package cc.xuepeng.ray.framework.core.log.entity;

import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogType;
import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统操作日志的实体类
 * 数据库表：sys_operate_log，系统操作日志表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLog extends BaseEntity {

    /**
     * 日志类型：1=访问日志；2=错误日志
     * 数据库字段：type,tinyint(2)
     */
    private SysOperateLogType type;

    /**
     * 操作人
     * 数据库字段：create_user,varchar(32)
     */
    private String createUser;

    /**
     * 操作时间
     * 数据库字段：create_time,timestamp
     */
    private LocalDateTime createTime;

    /**
     * 手机号
     * 数据库字段：phone_number,char(32)
     */
    private String phoneNumber;

    /**
     * 模块名称
     * 数据库字段：module,varchar(16)
     */
    private String module;

    /**
     * 功能名称
     * 数据库字段：func,varchar(16)
     */
    private String func;

    /**
     * 功能描述
     * 数据库字段：remark,varchar(32)
     */
    private String remark;

    /**
     * 动作描述
     * 数据库字段：action,varchar(16)
     */
    private String action;

    /**
     * 请求IP
     * 数据库字段：ip,varchar(32)
     */
    private String ip;

    /**
     * 请求Url
     * 数据库字段：url,varchar(512)
     */
    private String url;

    /**
     * 请求Uri
     * 数据库字段：uri,varchar(512)
     */
    private String uri;

    /**
     * 请求Method
     * 数据库字段：method,varchar(32)
     */
    private String method;

    /**
     * 请求类名
     * 数据库字段：class_name,varchar(256)
     */
    private String className;

    /**
     * 请求方法名
     * 数据库字段：method_name,varchar(256)
     */
    private String methodName;

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
