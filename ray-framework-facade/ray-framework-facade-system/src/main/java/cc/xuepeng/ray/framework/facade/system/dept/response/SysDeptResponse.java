package cc.xuepeng.ray.framework.facade.system.dept.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统部门的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDeptResponse extends BaseResponse {

    /**
     * 父级编号
     */
    private String parentCode;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 状态：0=停用；1=启用；
     */
    private BizStatus status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子部门
     */
    private List<SysDeptResponse> children = new ArrayList<>();

}
