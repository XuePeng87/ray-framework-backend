package cc.xuepeng.ray.framework.module.log.repository.entity;

import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import lombok.*;

/**
 * 系操作日志详情的实体类
 * 数据库表：sys_operate_log_detail，系统操作日志详情表
 *
 * @author xuepeng
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysOperateLogDetail extends BaseEntity {

    /**
     * 日志主键
     * 数据库字段：log_id,bigint(20)
     */
    private Long logId;

    /**
     * 请求路径参数
     * 数据库字段：params,text
     */
    private String param;

    /**
     * 请求方法参数
     * 数据库字段：args,text
     */
    private String args;

    /**
     * 返回值
     * 数据库字段：result,text
     */
    private String result;

    /**
     * 错误信息
     * 数据库字段：error,text
     */
    private String error;

}
