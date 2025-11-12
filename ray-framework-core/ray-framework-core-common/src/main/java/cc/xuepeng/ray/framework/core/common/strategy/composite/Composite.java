package cc.xuepeng.ray.framework.core.common.strategy.composite;

/**
 * 组合模式的父类
 * 定义了组合模式的数据结构
 * 包括Id、Name、Pid和Children
 *
 * @author xuepeng
 */
public interface Composite {

    /**
     * @return 获取主键
     */
    String getNodeId();

    /**
     * @return 获取名称
     */
    String getNodeName();

    /**
     * @return 获取父级主键
     */
    String getNodePid();

    /**
     * 添加到子级
     *
     * @param composite 组合对象
     */
    void add(final Composite composite);

    /**
     * 移除子级
     *
     * @param index 组合对象索引
     */
    void remove(final int index);

}
