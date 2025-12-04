package cc.xuepeng.ray.framework.facade.system.user.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 系统用户的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 角色编号
     */
    @NotNull(message = "角色编号不能为空", groups = {create.class, update.class})
    private List<String> roleCodes;

    /**
     * 电话
     */
    @NotBlank(message = "手机号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "手机号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String phoneNumber;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "姓名长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 邮箱
     */
    @NotBlank(message = "邮箱不能为空", groups = {create.class, update.class})
    @Length(max = 128, message = "邮箱长度不能大于128个字符", groups = {create.class, update.class, page.class})
    @Email(message = "邮箱格式不正确", groups = {create.class, update.class, page.class})
    private String email;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private BizStatus status;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}
