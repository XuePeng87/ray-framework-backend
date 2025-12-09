package cc.xuepeng.ray.framework.facade.system.role.response;

import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import lombok.*;

/**
 * 系统角色的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysRoleResponse extends BaseResponse {

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

}
