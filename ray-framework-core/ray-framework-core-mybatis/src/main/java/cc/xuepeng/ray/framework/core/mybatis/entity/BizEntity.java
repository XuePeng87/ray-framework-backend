package cc.xuepeng.ray.framework.core.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.*;

import java.time.LocalDateTime;

/**
 * ORM实体类的业务类
 *
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BizEntity extends BaseEntity {

    /**
     * 是否删除
     * 数据库字段：deleted，tinyint(1)
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 创建人
     * 数据库字段：create_user，char(32)
     */
    private String createUser;

    /**
     * 创建时间
     * 数据库字段：create_time，timestamp
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     * 数据库字段：modify_user，char(32)
     */
    private String modifyUser;

    /**
     * 修改时间
     * 数据库字段：modify_time，timestamp
     */
    private LocalDateTime modifyTime;

}
