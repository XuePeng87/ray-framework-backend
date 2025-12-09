package cc.xuepeng.ray.framework.core.log.config;

import cc.xuepeng.ray.framework.core.log.property.LogProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {LogProperty.class})
public class LogConfiguration {
}
