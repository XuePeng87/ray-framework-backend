package cc.xuepeng.ray.framework.core.redis.config;

import cc.xuepeng.ray.framework.core.redis.property.RedisProperty;
import cc.xuepeng.ray.framework.core.redis.serializer.RedisJsonSerializer;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;

/**
 * Redis的配置类
 * 对RedisTemplate进行了序列化设置
 * Redis中的Key和HashKey采用String序列化
 * Redis中的Value和HashValue采用Json（Jackson）序列化
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(RedisProperty.class)
public class RedisConfiguration {

    /**
     * 创建一个RedisTemplate对象
     *
     * @return RedisTemplate对象
     */
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(final RedisProperty redisProperty) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // RedisKey使用String进行序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        // RedisValue使用Json进行序列化
        final Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = RedisJsonSerializer.serializer();
        redisTemplate.setValueSerializer(jsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jsonRedisSerializer);
        // 后置处理
        redisTemplate.setDefaultSerializer(StringRedisSerializer.UTF_8);
        redisTemplate.afterPropertiesSet();
        // 启用事务
        redisTemplate.setEnableTransactionSupport(redisProperty.getTransaction());
        return redisTemplate;
    }

    /**
     * 创建一个StringRedisTemplate对象
     *
     * @return StringRedisTemplate对象
     */
    @Bean(name = "stringRedisTemplate")
    @ConditionalOnMissingBean(name = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(final RedisProperty redisProperty) {
        // 配置redisTemplate
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        stringRedisTemplate.setEnableTransactionSupport(redisProperty.getTransaction());
        return stringRedisTemplate;
    }

    /**
     * Redis连接工厂
     */
    @Resource
    private LettuceConnectionFactory redisConnectionFactory;

}
