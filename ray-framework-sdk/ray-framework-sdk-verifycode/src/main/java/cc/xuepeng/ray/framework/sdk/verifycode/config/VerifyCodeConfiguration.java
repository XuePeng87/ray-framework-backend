package cc.xuepeng.ray.framework.sdk.verifycode.config;

import cc.xuepeng.ray.framework.sdk.verifycode.property.VerifyCodeProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码的配置类
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(VerifyCodeProperty.class)
public class VerifyCodeConfiguration {
}
