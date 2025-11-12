package cc.xuepeng.ray.framework.core.common.domain.result;

import lombok.Getter;

/**
 * Result的默认状态
 * 包括成功、超时、参数错误、操作失败、授权失败、系统异常等错误
 *
 * @author xuepeng
 */
@Getter
public enum DefaultResultStatus implements ResultStatus {

    /**
     * 成功
     */
    SUCCESS(20000, "成功"),

    /**
     * 失败
     */
    FAIL(50000, "业务异常"),

    /**
     * 系统异常
     */
    ERROR(90000, "系统异常");

    /**
     * 构造函数
     *
     * @param code 状态编号
     * @param desc 状态描述
     */
    DefaultResultStatus(final int code, final String desc) {
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
