package cc.xuepeng.ray.framework.module.log.util;

import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import cc.xuepeng.ray.framework.module.log.dto.SysAuthLogDto;
import cc.xuepeng.ray.framework.module.log.dto.SysOperateLogDto;
import cn.hutool.http.useragent.UserAgent;
import jakarta.servlet.http.HttpServletRequest;

/**
 * UserAgentInfo工具类
 *
 * @author xuepeng
 */
public class UserAgentInfoUtil {

    private UserAgentInfoUtil() {
    }

    /**
     * 设置UserAgent
     *
     * @param sysAuthLogDto 系统登录登出的数据传输对象
     * @param request       请求对象
     */
    public static void setUserAgentInfo(final SysAuthLogDto sysAuthLogDto, final HttpServletRequest request) {
        final UserAgent userAgent = WebUtil.getUserAgent(request);
        sysAuthLogDto.setBrowser(userAgent.getBrowser().getName());
        sysAuthLogDto.setBrowserVersion(userAgent.getVersion());
        sysAuthLogDto.setPlatform(userAgent.getPlatform().getName());
        sysAuthLogDto.setOs(userAgent.getOs().getName());
        sysAuthLogDto.setOsVersion(userAgent.getOsVersion());
        sysAuthLogDto.setEngine(userAgent.getEngine().getName());
        sysAuthLogDto.setEngineVersion(userAgent.getEngineVersion());
    }

    /**
     * 设置UserAgent
     *Ø
     * @param request 请求对象
     */
    public static void setUserAgentInfo(final SysOperateLogDto sysOperateLogDto, final HttpServletRequest request) {
        final UserAgent userAgent = WebUtil.getUserAgent(request);
        sysOperateLogDto.setBrowser(userAgent.getBrowser().getName());
        sysOperateLogDto.setBrowserVersion(userAgent.getVersion());
        sysOperateLogDto.setPlatform(userAgent.getPlatform().getName());
        sysOperateLogDto.setOs(userAgent.getOs().getName());
        sysOperateLogDto.setOsVersion(userAgent.getOsVersion());
        sysOperateLogDto.setEngine(userAgent.getEngine().getName());
        sysOperateLogDto.setEngineVersion(userAgent.getEngineVersion());
    }

}
