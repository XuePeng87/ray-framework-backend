package cc.xuepeng.ray.framework.facade.system.dict.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统字典的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 16, message = "名称大于16个字符", groups = {create.class, update.class})
    private String name;

    /**
     * 字典值
     */
    @NotBlank(message = "字典值不能为空", groups = {create.class, update.class})
    @Length(max = 16, message = "字典值大于16个字符", groups = {create.class, update.class})
    private String value;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private BizStatus status;

    /**
     * 描述
     */
    @Length(max = 256, message = "描述大于32个字符", groups = {create.class, update.class})
    private String remark;

}
