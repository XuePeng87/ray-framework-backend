package cc.xuepeng.ray.framework.facade.system.tenent.response;

import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 系统租户的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysTenantResponse extends BaseResponse {

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
     * 有效期
     */
    private LocalDateTime expireTime;

    /**
     * 备注
     */
    private String remark;

}
