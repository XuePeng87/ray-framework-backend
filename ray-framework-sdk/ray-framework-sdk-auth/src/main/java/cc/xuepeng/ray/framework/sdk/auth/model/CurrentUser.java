package cc.xuepeng.ray.framework.sdk.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 当前登录用户的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String code;

    /**
     * 电话
     */
    private String phoneNumber;
    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 系统部门
     */
    private CurrentUserDept dept;

    /**
     * 系统角色
     */
    private List<CurrentUserRole> roles;

    /**
     * 系统授权
     */
    private List<String> permissions;

    /**
     * 系统功能
     */
    private List<CurrentUserFunc> funcs;

}
