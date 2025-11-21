package cc.xuepeng.ray.framework.facade.system.dept.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.core.mybatis.enums.BizStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统部门的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDeptRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 父级编号
     */
    @NotBlank(message = "父级编号不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "父级编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String parentCode;

    /**
     * 编号
     */
    @Length(max = 32, message = "编号长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 状态：0=停用；1=启用
     */
    @NotNull(message = "状态不能为空", groups = {create.class, update.class})
    private BizStatus status;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer sequence;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String remark;

}
