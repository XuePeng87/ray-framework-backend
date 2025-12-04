package cc.xuepeng.ray.framework.core.mybatis.consts;

/**
 * ORM字段使用的常量类
 *
 * @author xuepeng
 */
public final class ColumnConst {

    /**
     * 构造函数
     */
    private ColumnConst() {
    }

    /**
     * 逻辑删除字段名称
     */
    public static final String IS_DELETE = "deleted";

    /**
     * 创建时间字段名称
     */
    public static final String CREATE_TIME = "createTime";

    /**
     * 修改时间字段名称
     */
    public static final String MODIFY_TIME = "modifyTime";

}
