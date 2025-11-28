package cc.xuepeng.ray.framework.core.log.listener;

import cc.xuepeng.ray.framework.core.auth.annotation.AsyncAuthHandler;
import cc.xuepeng.ray.framework.core.log.domain.SysAuthLogDto;
import cc.xuepeng.ray.framework.core.auth.message.AsyncAuthMessage;
import cc.xuepeng.ray.framework.core.log.service.SysAuthLogService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * 系统登录认证日志RocketMQ消息消费者
 * 实现RocketMQListener接口，负责监听"sys-operate-log"主题的系统登录认证日志消息，
 * 接收消息后通过业务服务完成日志数据的持久化存储
 *
 * @author xuepeng
 */
@Slf4j
@Component
@RocketMQMessageListener(
        topic = "sys-auth-log",
        consumerGroup = "sys-auth-log-consumer-group"
)
public class SysAuthLogConsumer implements RocketMQListener<AsyncAuthMessage<SysAuthLogDto>> {

    /**
     * 处理接收到的系统登录认证日志消息
     * 对接收到的SysAuthLogDto类型消息进行处理，记录日志信息并调用系统登录认证日志服务完成数据持久化
     *
     * @param message 接收到的系统登录认证日志消息对象，包含待持久化的日志数据
     */
    @Override
    @AsyncAuthHandler
    public void onMessage(final AsyncAuthMessage<SysAuthLogDto> message) {
        log.info("RocketMQ -> 收到消息: {}", message);
        sysAuthLogService.create(message.getPayload());
    }

    /**
     * 系统登录登出日志的服务处理接口
     */
    @Resource
    private SysAuthLogService sysAuthLogService;

}
