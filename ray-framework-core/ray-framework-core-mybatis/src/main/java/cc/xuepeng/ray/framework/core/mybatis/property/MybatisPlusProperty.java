package cc.xuepeng.ray.framework.core.mybatis.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
public class MybatisPlusProperty {

    /**
     * 分页插件属性
     */
    private PageProperty page = new PageProperty();

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

}
