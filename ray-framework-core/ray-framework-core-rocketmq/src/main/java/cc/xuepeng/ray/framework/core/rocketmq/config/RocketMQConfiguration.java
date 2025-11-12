package cc.xuepeng.ray.framework.core.rocketmq.config;

import cc.xuepeng.ray.framework.core.rocketmq.client.RocketMQClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RocketMQ配置类
 *
 * @author xuepeng
 */
@Configuration
public class RocketMQConfiguration {

    @Bean(name = "rocketMQClient")
    public RocketMQClient rocketMQClient() {
        return new RocketMQClient();
    }

}
