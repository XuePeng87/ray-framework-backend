package cc.xuepeng.ray.framework.core.mybatis.plus.autofill;

import cc.xuepeng.ray.framework.core.mybatis.consts.ColumnConst;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * MyBatis-Plus 元对象字段填充处理器，用于实现实体类中创建时间和更新时间的自动填充。
 * 实现了插入时自动填充创建时间（createTime）、更新时自动填充更新时间（updateTime）的逻辑。
 *
 * @author xuepeng
 */
@Component
public class MyBatisAutoFillPlus implements MetaObjectHandler {

    /**
     * 插入操作时的自动填充逻辑
     * 当执行数据库插入操作时，自动为实体类的 "createTime" 字段填充当前时间
     *
     * @param metaObject 元对象，用于获取和设置实体类属性值
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, ColumnConst.CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

    /**
     * 更新操作时的自动填充逻辑
     * 当执行数据库更新操作时，自动为实体类的 "updateTime" 字段填充当前时间
     *
     * @param metaObject 元对象，用于获取和设置实体类属性值
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, ColumnConst.CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

}
