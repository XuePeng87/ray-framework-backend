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
     * 开始创建时间
     * <p>用于时间范围查询的起始时间，可以为null表示不限制起始时间</p>
     */
    private LocalDateTime beginCreateTime;

    /**
     * 结束创建时间
     * <p>用于时间范围查询的结束时间，可以为null表示不限制结束时间</p>
     */
    private LocalDateTime endCreateTime;

    /**
     * 开始修改时间
     * <p>用于时间范围查询的起始时间，可以为null表示不限制起始时间</p>
     */
    private LocalDateTime beginModifyTime;

    /**
     * 结束修改时间
     * <p>用于时间范围查询的结束时间，可以为null表示不限制结束时间</p>
     */
    private LocalDateTime endModifyTime;

    /**
     * 页码（从1开始）
     * <p>默认值为1，最小值为1，最大值为10000</p>
     */
    @Min(value = 1, message = "页码不能小于1", groups = {RequestValidateScope.page.class})
    @Max(value = 10000, message = "页码不能大于10000", groups = {RequestValidateScope.page.class})
    private Integer page = 1;

    /**
     * 每页记录数
     * <p>默认值为20，最小值为1，最大值为1000</p>
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
     * <p>支持：asc（升序）、desc（降序），默认为asc</p>
     */
    @Pattern(regexp = "^(asc|desc|ASC|DESC)$", message = "排序规则只能是asc或desc", groups = {RequestValidateScope.page.class, RequestValidateScope.list.class})
    private String order = "asc";

}
