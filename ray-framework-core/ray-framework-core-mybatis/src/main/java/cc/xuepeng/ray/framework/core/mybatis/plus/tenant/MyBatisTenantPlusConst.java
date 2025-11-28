package cc.xuepeng.ray.framework.core.mybatis.plus.tenant;

/**
 * 租户插件的常量类
 *
 * @author xuepeng
 */
public class MyBatisTenantPlusConst {

    /**
     * 构造函数
     */
    private MyBatisTenantPlusConst() {
    }

    /**
     * ThreadLocal中的Key
     */
    public static final String THREAD_LOCAL_KEY = "ignoreTenant";

}
