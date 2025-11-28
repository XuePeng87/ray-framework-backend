package cc.xuepeng.ray.framework.core.log.disruptor;

import cc.xuepeng.ray.framework.core.auth.message.AsyncAuthMessage;
import cc.xuepeng.ray.framework.core.disruptor.manager.GenericDisruptorManager;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统登录认证日志Disruptor管理器
 * 负责系统登录认证日志事件（SysAuthLogDto）的Disruptor队列管理，包括事件对象的创建工厂和事件处理器的配置
 *
 * @author xuepeng
 */
@Component
public class SysAuthLogDisruptorManager extends GenericDisruptorManager<AsyncAuthMessage<?>> {

    /**
     * 创建系统登录认证日志事件的工厂
     * 提供SysAuthLogDto对象的创建逻辑，使用默认构造函数实例化事件对象
     *
     * @return 用于创建SysAuthLogDto实例的EventFactory
     */
    @Override
    protected EventFactory<AsyncAuthMessage<?>> eventFactory() {
        return AsyncAuthMessage::new;
    }

    /**
     * 获取系统登录认证日志事件的处理器数组
     * 配置并返回用于处理SysAuthLogDto事件的处理器列表，当前使用注入的sysOperateLogEventHandler
     *
     * @return 包含系统登录认证日志事件处理器的EventHandler数组
     */
    @SuppressWarnings("unchecked")
    @Override
    protected EventHandler<AsyncAuthMessage<?>>[] eventHandlers() {
        return new EventHandler[]{sysAuthLogEventHandler};
    }


    /**
     * 系统登录认证日志事件处理器
     */
    @Resource
    private SysAuthLogEventHandler sysAuthLogEventHandler;

}
