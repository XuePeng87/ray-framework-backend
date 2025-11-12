package cc.xuepeng.ray.framework.module.log.api.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统操作日志的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 模块名称
     */
    @Length(max = 16, message = "模块名称不能大于16个字符", groups = {page.class})
    private String module;

}
