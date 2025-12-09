package cc.xuepeng.ray.framework.core.log.property;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 日志服务的自定义属性类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "ray.framework.core.log")
public class LogProperty {

    /**
     * 是否开启MQ传输日志
     */
    private Boolean messageQueueEnable = false;

}
