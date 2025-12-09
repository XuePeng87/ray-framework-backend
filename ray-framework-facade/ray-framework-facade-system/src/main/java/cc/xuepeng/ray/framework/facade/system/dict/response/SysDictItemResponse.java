package cc.xuepeng.ray.framework.facade.system.dict.response;

import cc.xuepeng.ray.framework.core.common.domain.enums.BizStatusDto;
import cc.xuepeng.ray.framework.core.common.domain.response.BaseResponse;
import lombok.*;

/**
 * 系统字典项的响应类
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysDictItemResponse extends BaseResponse {

    /**
     * 所属字典
     */
    private String dictValue;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 字典值
     */
    private String value;

    /**
     * 状态：0=停用；1=启用
     */
    private BizStatusDto status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 描述
     */
    private String remark;
    
}
