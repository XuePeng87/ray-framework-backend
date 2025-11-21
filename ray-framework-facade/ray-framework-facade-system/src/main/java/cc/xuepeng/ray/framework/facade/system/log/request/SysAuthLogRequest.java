package cc.xuepeng.ray.framework.facade.system.log.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.log.enums.SysAuthLogType;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统登录登出日志的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysAuthLogRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 日志类型：1=登录日志；2=登出日志
     */
    private SysAuthLogType type;

    /**
     * 请求IP
     */
    @Length(max = 32, message = "请求IP长度不能大于32个字符", groups = {page.class})
    private String loginIp;

}
