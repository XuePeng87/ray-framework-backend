package cc.xuepeng.ray.framework.module.log.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.log.enums.SysOperateLogTypeDto;
import lombok.*;

/**
 * 系统操作日志数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDto extends BaseDto {

    /**
     * 日志类型：1=访问日志；2=错误日志
     */
    private SysOperateLogTypeDto type;

    /**
     * 手机号
     */
    private String phoneNumber;

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

    /**
     * 操作日志详情
     */
    private SysOperateLogDetailDto detail = new SysOperateLogDetailDto();

    /**
     * 是否持久化
     */
    private boolean persistent;

}
