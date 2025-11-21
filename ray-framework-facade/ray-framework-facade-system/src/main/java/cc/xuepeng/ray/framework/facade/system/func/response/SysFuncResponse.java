package cc.xuepeng.ray.framework.facade.system.func.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import cc.xuepeng.ray.framework.module.func.enums.SysFuncTypeDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统功能的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysFuncResponse extends BaseResponse {

    /**
     * 父级编号
     */
    private String parentCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 编号
     */
    private String code;

    /**
     * 类型：0=目录，1=功能；2=按钮；3=外链
     */
    private SysFuncTypeDto type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String path;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 是否外链
     */
    private Boolean linkable;

    /**
     * 是否缓存
     */
    private Boolean cacheable;

    /**
     * 是否可见
     */
    private Boolean visible;

    /**
     * 始终显示根菜单
     */
    private Boolean alwaysShow;

    /**
     * 组件权限
     */
    private String permission;

    /**
     * 组件地址
     */
    private String component;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 备注
     */
    private String remark;

    /**
     * 子功能
     */
    private List<SysFuncResponse> children = new ArrayList<>();

}
