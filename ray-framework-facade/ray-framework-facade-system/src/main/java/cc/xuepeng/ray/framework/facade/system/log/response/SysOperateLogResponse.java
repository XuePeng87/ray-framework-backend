package cc.xuepeng.ray.framework.facade.system.log.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.core.log.enums.SysOperateLogType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统操作日志的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogResponse extends BaseResponse {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 操作人
     */
    private String createUser;

    /**
     * 操作时间
     */
    private LocalDateTime createTime;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 日志类型：1=操作日志；2=系统日志
     */
    private SysOperateLogType type;

    /**
     * 模块名称
     */
    private String module;

    /**
     * 功能名称
     */
    private String func;

    /**
     * 功能描述
     */
    private String remark;

    /**
     * 动作描述
     */
    private String action;

    /**
     * 请求IP
     */
    private String ip;

    /**
     * 请求Url
     */
    private String url;

    /**
     * 请求Uri
     */
    private String uri;

    /**
     * 请求Method
     */
    private String method;

    /**
     * 请求类名
     */
    private String className;

    /**
     * 请求方法名
     */
    private String methodName;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 浏览器版本
     */
    private String browserVersion;

    /**
     * 平台
     */
    private String platform;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 操作系统版本
     */
    private String osVersion;

    /**
     * 引擎
     */
    private String engine;

    /**
     * 引擎版本
     */
    private String engineVersion;

    /**
     * 操作时间
     */
    private Long exeTime;

}
