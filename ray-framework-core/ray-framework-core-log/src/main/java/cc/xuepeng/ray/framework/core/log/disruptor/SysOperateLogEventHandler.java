package cc.xuepeng.ray.framework.core.log.disruptor;

import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import cc.xuepeng.ray.framework.core.log.property.LogProperty;
import cc.xuepeng.ray.framework.core.log.service.SysOperateLogService;
import cc.xuepeng.ray.framework.core.rocketmq.client.RocketMQClient;
import com.lmax.disruptor.EventHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志事件处理器
 * 实现Disruptor的EventHandler接口，负责处理系统操作日志事件（SysOperateLogDto）的具体业务逻辑，
 * 包括日志记录和通过RocketMQ进行事件持久化
 *
 * @author xuepeng
 */
@Slf4j
@Component
public class SysOperateLogEventHandler implements EventHandler<SysOperateLogDto> {

    /**
     * 处理系统操作日志事件
     * 对接收的系统操作日志事件进行处理，首先记录日志信息，当事件需要持久化时通过RocketMQ客户端发送消息
     *
     * @param event      系统操作日志事件对象，包含具体的日志数据
     * @param sequence   事件在Disruptor环形缓冲区中的序列号
     * @param endOfBatch 是否为当前批次中的最后一个事件
     */
    @Override
    public void onEvent(SysOperateLogDto event, long sequence, boolean endOfBatch) {
        log.info("Disruptor -> 收到消息: {}", event.toString());
        if(BooleanUtils.isTrue(logProperty.getMessageQueueEnable())) {
            rocketMQClient.syncSend("sys-operate-log", event);
        } else {
            sysOperateLogService.create(event);
        }
    }

    /**
     * RocketMQ客户端
     */
    @Resource
    private RocketMQClient rocketMQClient;

    /**
     * 日志服务的自定义属性类
     */
    @Resource
    private LogProperty logProperty;

    /**
     * 系统操作日志的服务处理接口
     */
    @Resource
    private SysOperateLogService sysOperateLogService;

}
