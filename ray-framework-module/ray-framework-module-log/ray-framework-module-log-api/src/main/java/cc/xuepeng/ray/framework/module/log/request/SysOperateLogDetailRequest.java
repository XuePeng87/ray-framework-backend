package cc.xuepeng.ray.framework.module.log.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import lombok.*;

/**
 * 系统操作日志的详情的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDetailRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 日志主键
     */
    private Long logId;

    /**
     * 请求路径参数
     */
    private String param;

    /**
     * 请求方法参数
     */
    private String args;

    /**
     * 返回值
     */
    private String result;

    /**
     * 错误信息
     */
    private String error;

}
