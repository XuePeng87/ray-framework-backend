package cc.xuepeng.ray.framework.core.web.util;

import cc.xuepeng.ray.framework.core.common.consts.PunctuationConst;
import cc.xuepeng.ray.framework.core.web.consts.HttpHeaderConst;
import cc.xuepeng.ray.framework.core.web.consts.IPConst;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * Web工具类
 *
 * @author xuepeng
 */
public class WebUtil {

    /**
     * 构造函数
     */
    private WebUtil() {
    }

    /**
     * @return 获取当前请求的HttpServletRequest对象
     */
    public static HttpServletRequest getHttpServletRequest() {
        final RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        return (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
    }

    /**
     * 获取请求IP
     *
     * @param request HttpServletRequest对象
     * @return 请求IP
     */
    public static String getIPAddress(final HttpServletRequest request) {
        String ip = request.getHeader(IPConst.X_FORWARDED_FOR);
        if (StringUtils.isNotEmpty(ip)
                && !IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            ip = ip.split(PunctuationConst.COMMA)[0].split(PunctuationConst.COLON)[0];
        }
        return doGetIPAddress(ip, request);
    }

    /**
     * 获取UserAgent信息
     *
     * @param request HttpServletRequest对象
     * @return UserAgent信息
     */
    public static UserAgent getUserAgent(final HttpServletRequest request) {
        return UserAgentUtil.parse(request.getHeader(HttpHeaderConst.USER_AGENT));
    }

    /**
     * 获取真实IP
     *
     * @param ip      IP地址
     * @param request HttpServletRequest对象
     * @return 真实IP
     */
    private static String doGetIPAddress(String ip, final HttpServletRequest request) {
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.HTTP_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(IPConst.X_REAL_IP);
        }
        if (StringUtils.isEmpty(ip) || IPConst.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
