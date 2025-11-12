package cc.xuepeng.ray.framework.sdk.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 当前用户部门的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserFunc implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 路由跳转地址
     */
    private String redirect;

    /**
     * 路由名称
     */
    private String name;

    /**
     * 路由元数据
     */
    private CurrentUserFuncMeta meta;

    /**
     * 子功能
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CurrentUserFunc> children;

    @Data
    @ToString
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CurrentUserFuncMeta implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * 路由标题
         */
        private String title;

        /**
         * 路由图标
         */
        private String icon;

        /**
         * 路由是否隐藏
         */
        private Boolean hidden;

        /**
         * 路由是否缓存
         */
        private Boolean keepAlive;

        /**
         * 路由始终显示根
         */
        private Boolean alwaysShow;

    }

}
