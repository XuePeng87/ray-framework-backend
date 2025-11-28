package cc.xuepeng.ray.framework.module.auth.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 系统登录的请求类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 帐号
     */
    @NotBlank(message = "手机号码不能为空")
    @Length(max = 32, message = "手机号码长度不能大于32个字符")
    private String phoneNumber;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码编号
     */
    @Length(max = 32, message = "验证码编号长度不能大于32个字符")
    private String uuid;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    private String code;

}
