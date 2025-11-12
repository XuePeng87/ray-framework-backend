package cc.xuepeng.ray.framework.core.web.consts;

/**
 * IP操作相关的常量
 *
 * @author xuepeng
 */
public final class IPConst {

    /**
     * 构造函数
     */
    private IPConst() {
    }

    /**
     * 转发
     */
    public static final String X_FORWARDED_FOR = "x-forwarded-for";

    /**
     * 代理
     */
    public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";

    /**
     * WL代理
     */
    public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";

    /**
     * 客户端
     */
    public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";

    /**
     * 客户端转发
     */
    public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

    /**
     * 真实IP
     */
    public static final String X_REAL_IP = "X-Real-IP";

    /**
     * 本机HOST
     */
    public static final String LOCALHOST = "localhost";

    /**
     * 本机IPV4
     */
    public static final String LOCALHOST_IP = "127.0.0.1";

    /**
     * 本机IPV6
     */
    public static final String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    /**
     * 不识别
     */
    public static final String UNKNOWN = "unknown";

}
