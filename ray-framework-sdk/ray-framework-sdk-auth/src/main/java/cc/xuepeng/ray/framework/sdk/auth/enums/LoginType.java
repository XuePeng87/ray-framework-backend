package cc.xuepeng.ray.framework.sdk.auth.enums;

import cc.xuepeng.ray.framework.core.common.domain.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 登录方式
 *
 * @author xuepeng
 */
@Getter
@ToString
@AllArgsConstructor
public enum LoginType implements BaseEnum {

    /**
     * 密码登录
     */
    PASSWORD(1, "密码登录");

    /**
     * 枚举编号
     */
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String desc;

}
