package cc.xuepeng.ray.framework.app.config;

import cc.xuepeng.ray.framework.core.web.converter.EnumConverterFactory;
import cc.xuepeng.ray.framework.core.web.converter.Jackson2HttpMessageConverter;
import cc.xuepeng.ray.framework.core.web.converter.LocalDateTimeConverter;
import cc.xuepeng.ray.framework.core.web.interceptor.LogTrackInterceptor;
import cc.xuepeng.ray.framework.core.web.security.cors.CorsProperty;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

/**
 * Web应用配置类
 * 1、配置跨域信息，如果不是生产环境则可以跨域请求
 * 2、配置日志追踪ID，对所有请求生效，在Response的HttpHeader中添加X-Trace-Id
 * 3、配置请求参数的枚举转换器、日志转换器
 * 4、配置请求体JSON转换器，处理Ajax的Body中的数据
 *
 * @author xuepeng
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    /**
     * 设置跨域过滤器
     *
     * @return 跨域过滤器
     */
    @Bean
    @Profile("!prod")
    public CorsFilter corsFilter() {
        final CorsConfiguration corsConfig = new CorsConfiguration();
        final CorsProperty corsProperty = new CorsProperty();
        corsConfig.setAllowedOriginPatterns(Collections.singletonList(corsProperty.getOrigins()));
        corsConfig.addAllowedHeader(corsProperty.getHeaders());
        corsConfig.addAllowedMethod(corsProperty.getMethods());
        corsConfig.setAllowCredentials(corsProperty.isCredentials());
        corsConfig.setMaxAge(corsProperty.getAge());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getMapping(), corsConfig);
        return new CorsFilter(source);
    }

    /**
     * 注册日志拦截器
     * 对所有API(/**)生效
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogTrackInterceptor()).addPathPatterns("/**");
    }

    /**
     * 注册Spring MVC的自定义转换器
     *
     * @param registry 转换器注册器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateTimeConverter());
        registry.addConverterFactory(new EnumConverterFactory());
    }

    /**
     * @return 配置Jackson序列化，处理ajax请求中的LocalDateTime类型
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customizer() {
        return new Jackson2HttpMessageConverter().customizer();
    }

}
