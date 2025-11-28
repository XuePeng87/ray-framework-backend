package cc.xuepeng.ray.framework.facade.system.tenent.request;

import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

/**
 * 系统租户的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysTenantRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 128, message = "名称长度不能大于128个字符", groups = {create.class, update.class, regedit.class, page.class})
    private String name;

    /**
     * 手机
     */
    @NotBlank(message = "电话号不能为空", groups = {create.class, update.class, regedit.class})
    @Length(max = 32, message = "手机号长度不能大于32个字符", groups = {create.class, update.class, regedit.class, page.class})
    private String phoneNumber;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空", groups = {create.class, update.class, regedit.class})
    @Length(max = 128, message = "邮箱长度不能大于128个字符", groups = {create.class, update.class, regedit.class, page.class})
    @Email(message = "邮箱格式不正确")
    private String email;

    /**
     * 状态：0=停用；1=启用；
     */
    private BizStatusDto status;

    /**
     * 有效期
     */
    private LocalDateTime tenantExpireTime;

    /**
     * 有效期开始时间
     */
    private LocalDateTime beginExpireTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime endExpireTime;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}
