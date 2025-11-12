package cc.xuepeng.ray.framework.core.web.handler;

import cc.xuepeng.ray.framework.core.common.domain.result.ResultStatus;
import lombok.Getter;

/**
 * 全局异常响应状态类
 *
 * @author xuepeng
 */
@Getter
public enum GlobalResultStatus implements ResultStatus {

    REQUEST_BAD(40000, "请求参数非法"),

    REQUEST_LIMIT(40200, "请求过于频繁");

    /**
     * 构造函数
     *
     * @param code 状态编号
     * @param desc 状态描述
     */
    GlobalResultStatus(
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
