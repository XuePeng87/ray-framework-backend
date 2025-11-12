package cc.xuepeng.ray.framework.module.log.domain.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.module.log.domain.enums.SysAuthLogTypeDto;
import lombok.*;

/**
 * 系统登录登出日志数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysAuthLogDto extends BaseDto {

    /**
     * 日志类型：1=登录日志；2=登出日志
     */
    private SysAuthLogTypeDto type;

    /**
     * 登录IP地址
     */
    private String loginIp;

    /**
     * 登录人
     */
    private String userCode;

    /**
     * 手机号
     */
    private String phoneNumber;

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
