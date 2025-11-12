package cc.xuepeng.ray.framework.core.mybatis.consts;

/**
 * ORM查询使用的常量类
 *
 * @author xuepeng
 */
public final class QueryConst {

    /**
     * 构造函数
     */
    private QueryConst() {
    }

    /**
     * 未查询到数据是否抛出异常
     */
    public static final boolean QUERY_NULL_THROW_EX = Boolean.FALSE;

    /**
     * 生序
     */
    public static final String ASC = "asc";

    /**
     * 降序
     */
    public static final String DESC = "desc";

}
