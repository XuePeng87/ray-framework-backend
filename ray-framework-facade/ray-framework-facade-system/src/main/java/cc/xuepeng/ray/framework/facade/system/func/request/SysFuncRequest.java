package cc.xuepeng.ray.framework.facade.system.func.request;

import cc.xuepeng.ray.framework.core.common.domain.request.BaseRequest;
import cc.xuepeng.ray.framework.core.common.domain.request.RequestValidateScope;
import cc.xuepeng.ray.framework.module.func.enums.SysFuncTypeDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 系统功能的请求参数类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncRequest extends BaseRequest implements RequestValidateScope {

    /**
     * 父级编号
     */
    @NotBlank(message = "父级编号不能为空", groups = {create.class, update.class})
    private String parentCode;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空", groups = {create.class, update.class})
    @Length(max = 32, message = "名称长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String name;

    /**
     * 类型：0=目录，1=功能；2=按钮；3=外链
     */
    @NotNull(message = "类型不能为空", groups = {create.class, update.class})
    private SysFuncTypeDto type;

    /**
     * 图标
     */
    @Length(max = 32, message = "图标长度不能大于32个字符", groups = {create.class, update.class, page.class})
    private String icon;

    /**
     * 路由地址
     */
    @Length(max = 256, message = "路由地址长度不能大于256个字符", groups = {create.class, update.class, page.class})
    private String path;

    /**
     * 重定向地址
     */
    @Length(max = 128, message = "重定向地址长度不能大于128个字符", groups = {create.class, update.class, page.class})
    private String redirect;

    /**
     * 是否外链
     */
    private Boolean linkable;

    /**
     * 是否缓存
     */
    @NotNull(message = "是否缓存不能为空", groups = {create.class, update.class})
    private Boolean cacheable;

    /**
     * 是否可见
     */
    @NotNull(message = "是否可见不能为空", groups = {create.class, update.class})
    private Boolean visible;

    /**
     * 始终显示根菜单
     */
    @NotNull(message = "始终显示根菜单不能为空", groups = {create.class, update.class})
    private Boolean alwaysShow;

    /**
     * 组件权限
     */
    @Length(max = 64, message = "组件名称长度不能大于64个字符", groups = {create.class, update.class, page.class})
    private String permission;

    /**
     * 组件地址
     */
    @Length(max = 256, message = "组件地址长度不能大于256个字符")
    private String component;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空", groups = {create.class, update.class})
    private Integer sequence;

    /**
     * 备注
     */
    @Length(max = 256, message = "备注地址长度不能大于256个字符")
    private String remark;

}
