package cc.xuepeng.ray.framework.sdk.auth.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 当前登录用户角色的实体类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String code;

    /**
     * 名称
     */
    private String name;

}
