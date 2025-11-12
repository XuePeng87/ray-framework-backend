package cc.xuepeng.ray.framework.core.rocketmq.client;

import cc.xuepeng.ray.framework.core.rocketmq.exception.RocketMQSendFailedException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.support.MessageBuilder;

/**
 * RocketMQ客户端
 *
 * @author xuepeng
 */
@Slf4j
public class RocketMQClient {

    /**
     * 同步发送消息
     */
    public <T> SendResult syncSend(String topic, T message) {
        try {
            SendResult result = rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(message).build());
            log.info("【RocketMQ】同步发送成功，Topic={}, Msg={}", topic, message);
            return result;
        } catch (Exception e) {
            log.error("【RocketMQ】同步发送失败，Topic={}, Msg={}", topic, message, e);
            throw new RocketMQSendFailedException(e);
        }
    }

    /**
     * 异步发送消息
     */
    public <T> void asyncSend(String topic, T message, SendCallback callback) {
        try {
            rocketMQTemplate.asyncSend(topic, MessageBuilder.withPayload(message).build(), callback);
            log.info("【RocketMQ】异步发送中，Topic={}, Msg={}", topic, message);
        } catch (Exception e) {
            log.error("【RocketMQ】异步发送失败，Topic={}, Msg={}", topic, message, e);
        }
    }

    /**
     * 单向发送消息（不关心结果）
     */
    public <T> void sendOneWay(String topic, T message) {
        try {
            rocketMQTemplate.sendOneWay(topic, MessageBuilder.withPayload(message).build());
            log.info("【RocketMQ】单向发送成功，Topic={}, Msg={}", topic, message);
        } catch (Exception e) {
            log.error("【RocketMQ】单向发送失败，Topic={}, Msg={}", topic, message, e);
        }
    }

    /**
     * 发送延时消息（使用 delayLevel）
     * delayLevel 示例：
     * 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
     */
    public <T> void sendDelayMessage(String topic, T message, int delayLevel) {
        try {
            rocketMQTemplate.syncSend(topic, MessageBuilder.withPayload(message).build(), 3000, delayLevel);
            log.info("【RocketMQ】延时发送成功，Topic={}, Msg={}, delayLevel={}", topic, message, delayLevel);
        } catch (Exception e) {
            log.error("【RocketMQ】延时发送失败，Topic={}, Msg={}", topic, message, e);
        }
    }

    /**
     * RocketMQ工具类
     */
    @Resource
    private RocketMQTemplate rocketMQTemplate;

}
