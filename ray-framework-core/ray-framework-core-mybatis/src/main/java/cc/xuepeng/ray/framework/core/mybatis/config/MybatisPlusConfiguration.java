package cc.xuepeng.ray.framework.core.mybatis.config;

import cc.xuepeng.ray.framework.core.mybatis.consts.ColumnConst;
import cc.xuepeng.ray.framework.core.mybatis.property.MybatisPlusProperty;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBaits Plus的配置类
 * 自动扫描basePackages下的Dao类
 *
 * @author xuepeng
 */
@Configuration
@MapperScan(basePackages = {"cc.xuepeng.ray.framework.**.repository"})
@EnableConfigurationProperties(MybatisPlusProperty.class)
public class MybatisPlusConfiguration {

    /**
     * @return 配置MyBatisPlus属性
     */
    @Bean
    public MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer() {
        return properties -> {
            // MyBatis Plus的配置
            properties.setMapperLocations(new String[]{"classpath*:mapper/*.xml"});
            final GlobalConfig globalConfig = properties.getGlobalConfig();
            globalConfig.setBanner(false);
            globalConfig.getDbConfig().setLogicDeleteField(ColumnConst.IS_DELETE);
            globalConfig.getDbConfig().setLogicDeleteValue("1");
            globalConfig.getDbConfig().setLogicNotDeleteValue("0");
            // MyBatis的配置
            MybatisPlusProperties.CoreConfiguration configuration = new MybatisPlusProperties.CoreConfiguration();
            configuration.setDefaultEnumTypeHandler(MybatisEnumTypeHandler.class);
            configuration.setLogImpl(StdOutImpl.class);
            properties.setConfiguration(configuration);
        };
    }

    /**
     * @return 添加插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(final MybatisPlusProperty mybatisPlusProperty) {
        final MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 添加分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor(mybatisPlusProperty));
        // 添加乐观锁插件
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor());
        // 防止全表更新或删除插件
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor());
        // 数据权限插件
        return interceptor;
    }

    /**
     * @return 配置分页插件
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(MybatisPlusProperty mybatisPlusProperty) {
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setMaxLimit(mybatisPlusProperty.getPage().getPageLimit());
        paginationInterceptor.setOverflow(mybatisPlusProperty.getPage().getOverflow());
        paginationInterceptor.setOptimizeJoin(mybatisPlusProperty.getPage().getOptimizeJoin());
        return paginationInterceptor;
    }

    /**
     * @return 配置乐观锁插件
     */
    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * @return 防全表更新或删除的插件
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }

}
