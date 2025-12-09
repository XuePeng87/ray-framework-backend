package cc.xuepeng.ray.framework.facade.system.user.response;

import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import lombok.*;

import java.util.List;

/**
 * 系统用户的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserResponse extends BaseResponse {

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 角色编号集合
     */
    private List<String> roleCodes;

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
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 备注
     */
    private String remark;

}
