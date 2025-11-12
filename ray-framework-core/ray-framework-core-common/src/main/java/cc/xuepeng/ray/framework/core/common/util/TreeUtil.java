package cc.xuepeng.ray.framework.core.common.util;

import cc.xuepeng.ray.framework.core.common.strategy.composite.Composite;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Strings;

import java.util.List;

/**
 * 树结构的工具类
 *
 * @author xuepeng
 */
public class TreeUtil {

    /**
     * 默认的父级主键
     */
    private static final String DEFAULT_PID = "0";

    /**
     * 构造函数
     */
    private TreeUtil() {
    }

    /**
     * 转换树结构
     *
     * @param list 要转换的集合
     * @param <T>  实现Composite的类
     * @return 转换后的树型结构
     */
    public static <T extends Composite> List<T> format(final List<T> list) {
        return format(list, DEFAULT_PID);
    }

    /**
     * 转换树结构
     *
     * @param list    要转换的集合
     * @param rootVal 跟节点的值
     * @param <T>     实现Composite的类
     * @return 转换后的树型结构
     */
    public static <T extends Composite> List<T> format(final List<T> list, final String rootVal) {
        // 获取所有一级对象
        final List<T> roots = list.stream()
                .filter(item -> Strings.CI.equals(item.getNodePid(), rootVal))
                .toList();
        if (CollectionUtils.isEmpty(roots))
            return list;
        // 递归生成树结构
        roots.forEach(root -> tree(root, list));
        return roots;
    }

    /**
     * 递归生成树结构
     *
     * @param parent 根节点
     * @param nodes  要转换的结合
     * @param <T>    实现Composite的类
     */
    private static <T extends Composite> void tree(final T parent, final List<T> nodes) {
        nodes.stream()
                .filter(node -> Strings.CI.equals(node.getNodePid(), parent.getNodeId()))
                .forEach(node -> {
                    parent.add(node);
                    tree(node, nodes);
                });
    }

}
