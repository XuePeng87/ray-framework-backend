package cc.xuepeng.ray.framework.core.log.disruptor;

import cc.xuepeng.ray.framework.core.disruptor.manager.GenericDisruptorManager;
import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志Disruptor管理器
 * 负责系统操作日志事件（SysOperateLogDto）的Disruptor队列管理，包括事件对象的创建工厂和事件处理器的配置
 *
 * @author xuepeng
 */
@Component
public class SysOperateLogDisruptorManager extends GenericDisruptorManager<SysOperateLogDto> {

    /**
     * 创建系统操作日志事件的工厂
     * 提供SysOperateLogDto对象的创建逻辑，使用默认构造函数实例化事件对象
     *
     * @return 用于创建SysOperateLogDto实例的EventFactory
     */
    @Override
    protected EventFactory<SysOperateLogDto> eventFactory() {
        return SysOperateLogDto::new;
    }

    /**
     * 获取系统操作日志事件的处理器数组
     * 配置并返回用于处理SysOperateLogDto事件的处理器列表，当前使用注入的sysOperateLogEventHandler
     *
     * @return 包含系统操作日志事件处理器的EventHandler数组
     */
    @SuppressWarnings("unchecked")
    @Override
    protected EventHandler<SysOperateLogDto>[] eventHandlers() {
        return new EventHandler[]{sysOperateLogEventHandler};
    }


    /**
     * 系统操作日志事件处理器
     */
    @Resource
    private SysOperateLogEventHandler sysOperateLogEventHandler;

}
