package cc.xuepeng.ray.framework.core.mybatis.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * MybatisPlus的自定义属性类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ray.framework.core.mybatis")
public class MyBatisPlusProperty {

    /**
     * 分页插件属性
     */
    private PageProperty page = new PageProperty();

    /**
     * 租户插件属性
     */
    private TenantProperty tenant = new TenantProperty();

    /**
     * 分页插件配置
     *
     * @author xuepeng
     */
    @Data
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageProperty {

        /**
         * 分页最大数
         */
        private Long pageLimit = 100L;

        /**
         * 溢出总页数后是否进行处理
         */
        private Boolean overflow = false;

        /**
         * join优化
         */
        private Boolean optimizeJoin = false;

    }

    /**
     * 租户插件配置
     *
     * @author xuepeng
     */
    @Data
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TenantProperty {

        /**
         * 是否开启租户插件
         */
        private Boolean enable = false;

        /**
         * 租户字段名称
         */
        private String columnName = "tenant_code";

        /**
         * 忽略租户隔离的表名
         */
        private Set<String> ignoresTables = new HashSet<>();

    }

}
