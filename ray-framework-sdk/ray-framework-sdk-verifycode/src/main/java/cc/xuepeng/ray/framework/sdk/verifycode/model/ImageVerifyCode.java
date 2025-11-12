package cc.xuepeng.ray.framework.sdk.verifycode.model;

import lombok.*;

/**
 * 图片验证码的实体类
 *
 * @author xuepeng
 */
@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ImageVerifyCode {

    /**
     * 唯一标识
     */
    private String uuid;

    /**
     * 验证图片
     */
    private String img;

}
