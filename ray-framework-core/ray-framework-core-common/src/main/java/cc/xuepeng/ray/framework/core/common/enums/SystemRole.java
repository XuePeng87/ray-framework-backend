package cc.xuepeng.ray.framework.core.common.enums;

import cc.xuepeng.ray.framework.core.common.domain.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 系统角色
 *
 * @author xuepeng
 */
@Getter
@AllArgsConstructor
@ToString
public enum SystemRole implements BaseEnum {

    SUPER_ADMIN(1, "ROLE_SUPER_ADMIN"),

    SYSTEM_ADMIN(2, "ROLE_SYSTEM_ADMIN");

    /**
     * 枚举编号
     */
    private final Integer code;

    /**
     * 枚举描述
     */
    private final String desc;

}
