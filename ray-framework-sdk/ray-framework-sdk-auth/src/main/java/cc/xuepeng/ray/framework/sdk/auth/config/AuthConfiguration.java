package cc.xuepeng.ray.framework.sdk.auth.config;

import cc.xuepeng.ray.framework.sdk.auth.property.AuthProperty;
import cn.dev33.satoken.interceptor.SaInterceptor;
import jakarta.annotation.Resource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 认证服务的配置类
 *
 * @author xuepeng
 */
@Configuration
@EnableConfigurationProperties(value = {AuthProperty.class})
public class AuthConfiguration implements WebMvcConfigurer {

    /**
     * 注册SaToken的注解拦截器
     *
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor())
                .addPathPatterns(authProperty.getIncludePath())
                .excludePathPatterns(authProperty.getExcludePaths());
    }

    /**
     * 认证服务的自定义属性对象
     */
    @Resource
    private AuthProperty authProperty;

}
