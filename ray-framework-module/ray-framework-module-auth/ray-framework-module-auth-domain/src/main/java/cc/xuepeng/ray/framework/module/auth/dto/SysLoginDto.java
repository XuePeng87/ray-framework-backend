package cc.xuepeng.ray.framework.module.auth.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 系统登录的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 登录IP地址
     */
    private String ip;

    /**
     * 验证码编号
     */
    private String uuid;

}
