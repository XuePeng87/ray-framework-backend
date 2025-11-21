package cc.xuepeng.ray.framework.core.common.util;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

import java.io.Serializable;
import java.util.List;

/**
 * ExistsUtil 类是一个用于验证某个对象是否存在的工具类
 * 它提供了静态方法来判断值在给定列表中是否存在，以及一个自定义的 Lambda 接口来定义存在性检查逻辑
 *
 * @author xuepeng
 */
public class ExistsUtil {

    /**
     * 私有构造函数，防止外部实例化该类
     * 因为该类提供的是静态方法，所以不需要实例化
     */
    private ExistsUtil() {
    }

    /**
     * 判断值是否存在
     * 如果值在列表中存在，则返回 true；否则返回 false
     * 该方法通过调用另一个重载的 exists 方法，并传入一个默认的存在性检查逻辑
     *
     * @param list  根据要验证的值查询出的数据列表
     * @param value 要验证是否存在的值
     * @param field 用于从列表中的对象获取唯一标识的属性名
     * @return 如果值存在，则返回 true；否则返回 false
     */
    public static <T> boolean exists(final List<T> list, final String value, final String field) {
        return exists(list, value, (l, v) -> {
            if (l.size() > 1) {
                // 如果list中的数据数量大于1个，则表示已经存在了，返回true
                return true;
            } else if (l.isEmpty()) {
                // 如果list中没有记录，则认为是要新增，此时返回false
                return false;
            } else {
                // 如果list中只有一行记录，且value相等，则认为是对某个数据进行修改，此时返回true
                // 场景为修改时，如果list中的数据就是要修改的数据，则返回false，如果list中的数据不是要修改的数据，则返回true
                final MethodAccess access = MethodAccess.get(l.getFirst().getClass());
                final String id = access.invoke(l.getFirst(), "get" + field).toString();
                return StringUtils.isEmpty((CharSequence) v) || !Strings.CI.equals(id, (CharSequence) v);
            }
        });
    }

    /**
     * 判断值是否存在
     * 该方法接受一个自定义的 Lambda 表达式（ExistsFunction 接口的实现），用于定义存在性检查逻辑
     *
     * @param list           数据列表
     * @param value          要验证是否存在的值
     * @param existsFunction 自定义的存在性检查逻辑
     * @return 如果值存在，则返回 true；否则返回 false
     */
    public static <T> boolean exists(final List<T> list, final String value, final ExistsFunction<T> existsFunction) {
        return existsFunction.exists(list, value);
    }

    /**
     * ExistsFunction 是一个函数式接口，用于定义值存在性的检查逻辑
     * 实现该接口的类必须提供一个 exists 方法，该方法接受一个数据列表和一个要验证的值，并返回一个布尔值来表示值是否存在
     *
     * @param <T> 数据列表中的元素类型
     */
    @FunctionalInterface
    public interface ExistsFunction<T> {

        /**
         * 判断值是否存在
         *
         * @param list  根据要验证的值查询出的数据列表
         * @param value 要验证是否存在的值
         * @return 如果值存在，则返回 true；否则返回 false
         */
        boolean exists(List<T> list, Serializable value);

    }

}