package cc.xuepeng.ray.framework.core.log.listener;

import cc.xuepeng.ray.framework.core.log.domain.SysOperateLogDto;
import cc.xuepeng.ray.framework.core.log.service.SysOperateLogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 系统操作日志RocketMQ消息消费者
 * 实现RocketMQListener接口，负责监听"sys-operate-log"主题的系统操作日志消息，
 * 接收消息后通过业务服务完成日志数据的持久化存储
 *
 * @author xuepeng
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "sys-operate-log",
        consumerGroup = "sys-operate-log-consumer-group"
)
public class SysOperateLogConsumer implements RocketMQListener<SysOperateLogDto> {

    /**
     * 处理接收到的系统操作日志消息
     * 对接收到的SysOperateLogDto类型消息进行处理，记录日志信息并调用系统操作日志服务完成数据持久化
     *
     * @param message 接收到的系统操作日志消息对象，包含待持久化的日志数据
     */
    @Override
    public void onMessage(final SysOperateLogDto message) {
        log.info("【RocketMQ】收到消息: {}", message);
        sysOperateLogService.create(message);
    }

    /**
     * 系统操作日志的服务处理接口
     */
    @Resource
    private SysOperateLogService sysOperateLogService;

}
