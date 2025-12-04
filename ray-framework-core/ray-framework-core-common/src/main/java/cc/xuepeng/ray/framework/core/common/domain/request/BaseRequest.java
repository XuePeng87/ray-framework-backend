package cc.xuepeng.ray.framework.core.common.domain.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 请求参数的父类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest implements Serializable {

    /**
     * 租户编号
     */
    private String tenantCode;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 开始创建时间
     */
    private LocalDateTime beginCreateTime;

    /**
     * 结束创建时间
     */
    private LocalDateTime endCreateTime;

    /**
     * 开始修改时间
     */
    private LocalDateTime beginModifyTime;

    /**
     * 结束修改时间
     */
    private LocalDateTime endModifyTime;

    /**
     * 页码（从1开始）
     */
    @Min(value = 1, message = "页码不能小于1", groups = {RequestValidateScope.page.class})
    @Max(value = 10000, message = "页码不能大于10000", groups = {RequestValidateScope.page.class})
    private Integer page = 1;

    /**
     * 每页记录数
     */
    @Min(value = 1, message = "每页记录数不能小于1", groups = {RequestValidateScope.page.class})
    @Max(value = 1000, message = "每页记录数不能大于1000", groups = {RequestValidateScope.page.class})
    private Integer size = 20;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序规则
     */
    @Pattern(regexp = "^(asc|desc|ASC|DESC)$", message = "排序规则只能是asc或desc", groups = {RequestValidateScope.page.class, RequestValidateScope.list.class})
    private String order = "asc";

}
