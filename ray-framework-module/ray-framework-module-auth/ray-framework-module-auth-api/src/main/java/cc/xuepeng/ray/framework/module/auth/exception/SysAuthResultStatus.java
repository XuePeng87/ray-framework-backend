package cc.xuepeng.ray.framework.module.auth.exception;

import cc.xuepeng.ray.framework.core.common.domain.result.ResultStatus;
import lombok.Getter;

/**
 * 全局异常的响应状态类
 *
 * @author xuepeng
 */
@Getter
public enum SysAuthResultStatus implements ResultStatus {

    LOGIN_FAIL(50001, "登录失败"),

    LOGIN_LOCKED(50002, "账号锁定");

    /**
     * 构造函数
     *
     * @param code 状态编号
     * @param desc 状态描述
     */
    SysAuthResultStatus(
            final int code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 状态编号
     */
    private final int code;

    /**
     * 状态描述
     */
    private final String desc;

}
