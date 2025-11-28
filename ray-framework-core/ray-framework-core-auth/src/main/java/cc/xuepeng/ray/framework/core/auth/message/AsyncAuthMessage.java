package cc.xuepeng.ray.framework.core.auth.message;

import lombok.*;

/**
 * 认证消息类，封装了登录令牌和有效载荷
 * 主要解决SaToken跨线程异步操作认证鉴权失败的问题
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AsyncAuthMessage<T> {

    /**
     * 登录令牌，用于在RocketMQ消息中传递用户认证信息
     */
    private String token;

    /**
     * 有效载荷，用于在RocketMQ消息中传递业务数据
     */
    private T payload;

}
