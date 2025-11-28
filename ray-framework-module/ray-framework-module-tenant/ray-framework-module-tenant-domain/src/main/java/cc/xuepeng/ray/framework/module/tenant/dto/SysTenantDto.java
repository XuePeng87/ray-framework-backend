package cc.xuepeng.ray.framework.module.tenant.dto;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统租户的数据传输类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysTenantDto extends BaseDto {

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 手机
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 有效期
     */
    private LocalDateTime expireTime;

    /**
     * 有效期开始时间
     */
    private LocalDateTime beginExpireTime;

    /**
     * 有效期结束时间
     */
    private LocalDateTime endExpireTime;

    /**
     * 是否过期
     */
    private boolean expired;

    /**
     * 备注
     */
    private String remark;

}
