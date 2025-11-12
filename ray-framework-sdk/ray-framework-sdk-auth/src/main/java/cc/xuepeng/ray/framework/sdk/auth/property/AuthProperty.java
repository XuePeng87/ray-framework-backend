package cc.xuepeng.ray.framework.sdk.auth.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务的自定义属性类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ray.framework.sdk.auth")
public class AuthProperty {

    /**
     * 拦截路径
     */
    private String includePath = "/**";

    /**
     * 放行路径
     */
    private List<String> excludePaths = new ArrayList<>();

}
