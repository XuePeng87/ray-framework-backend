package cc.xuepeng.ray.framework.sdk.disruptor.manager;

import cc.xuepeng.ray.framework.sdk.disruptor.exception.DisruptorCopyMessageException;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * 通用Disruptor管理器抽象类
 * 该类提供了基于LMAX Disruptor的高性能事件处理框架的通用实现
 * Disruptor是一个高性能的异步处理框架，用于在不同线程间传递数据，
 * 通常用于高吞吐量和低延迟的场景
 * 子类需要实现事件工厂和事件处理器的创建方法，以定制具体的事件类型和处理逻辑
 *
 * @param <T> 事件类型参数
 */
public abstract class GenericDisruptorManager<T> {

    /**
     * Disruptor的RingBuffer实例，用于存储和传递事件
     */
    private RingBuffer<T> ringBuffer;

    /**
     * 创建事件工厂的抽象方法
     * 子类必须实现此方法来提供创建事件对象的工厂
     * 事件工厂负责在RingBuffer中预分配事件对象
     *
     * @return 事件工厂实例
     */
    protected abstract EventFactory<T> eventFactory();

    /**
     * 创建事件处理器数组的抽象方法
     * 子类必须实现此方法来提供处理事件的处理器
     * 事件处理器定义了如何消费和处理RingBuffer中的事件
     *
     * @return 事件处理器数组
     */
    protected abstract EventHandler<T>[] eventHandlers();

    /**
     * 初始化Disruptor实例
     * 该方法在Bean创建后自动调用，负责设置和启动Disruptor
     * 它配置了Disruptor的缓冲区大小、线程工厂、生产者类型和等待策略，
     * 并将事件处理器与Disruptor关联
     */
    @PostConstruct
    public void init() {
        Disruptor<T> disruptor = new Disruptor<>(
                eventFactory(),
                bufferSize(),
                Executors.defaultThreadFactory(),
                ProducerType.MULTI,
                new BlockingWaitStrategy()
        );
        disruptor.handleEventsWith(eventHandlers());
        disruptor.start();
        ringBuffer = disruptor.getRingBuffer();
    }

    /**
     * 获取RingBuffer的缓冲区大小
     * 默认实现返回8192（8K）的缓冲区大小
     * 子类可以重写此方法以提供自定义的缓冲区大小
     * 注意：缓冲区大小必须是2的幂次方
     *
     * @return RingBuffer的缓冲区大小
     */
    protected int bufferSize() {
        return 1024 * 8;
    }

    /**
     * 发布事件到RingBuffer
     * 该方法获取RingBuffer中的下一个序列，然后使用提供的Consumer
     * 填充事件对象，最后发布该事件使其对消费者可见
     *
     * @param filler 用于填充事件对象的Consumer函数
     */
    public void publish(Consumer<T> filler) {
        long seq = ringBuffer.next();
        try {
            T event = ringBuffer.get(seq);
            filler.accept(event);
        } finally {
            ringBuffer.publish(seq);
        }
    }

    public void publish(T source) {
        long seq = ringBuffer.next();
        try {
            T event = ringBuffer.get(seq);
            // 如果 T 是可复制的，可以调用 copyFrom
            if (event != source && hasCopyFromMethod(event)) {
                invokeCopyFrom(event, source);
            } else {
                BeanUtils.copyProperties(source, event);
            }

        } finally {
            ringBuffer.publish(seq);
        }
    }

    private boolean hasCopyFromMethod(T event) {
        try {
            event.getClass().getMethod("copyFrom", event.getClass());
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    private void invokeCopyFrom(T target, T source) {
        try {
            Method copyFrom = target.getClass().getMethod("copyFrom", source.getClass());
            copyFrom.invoke(target, source);
        } catch (Exception e) {
            throw new DisruptorCopyMessageException("Failed to copy event", e);
        }
    }

}
