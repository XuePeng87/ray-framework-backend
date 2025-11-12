package cc.xuepeng.ray.framework.sdk.verifycode.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * 验证码的自定义属性类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ray.framework.verify-code")
public class VerifyCodeProperty {

    /**
     * 缓存过期时间
     */
    private Duration expiration = Duration.ofMinutes(2);

    /**
     * 图片宽度
     */
    private Integer captchaImgWidth = 127;

    /**
     * 图片高度
     */
    private Integer captchaImgHeight = 40;

    /**
     * 验证码长度
     */
    private Integer captchaLength = 2;

}
