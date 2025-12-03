package cc.xuepeng.ray.framework.core.mybatis.plus.tenant;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.model.CurrentUserRole;
import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.common.enums.SystemRole;
import cc.xuepeng.ray.framework.core.common.util.ThreadLocalUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.TenantPlusConst;
import cc.xuepeng.ray.framework.core.mybatis.property.MyBatisPlusProperty;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;
import java.util.Set;

/**
 * 租户插件逻辑处理类
 *
 * @author xuepeng
 */
@Slf4j
public class MyBatisTenantPlus implements TenantLineHandler {

    /**
     * 构造函数
     *
     * @param myBatisPlusProperty   MybatisPlus的自定义属性类
     * @param identificationService 认证的业务处理接口
     */
    public MyBatisTenantPlus(MyBatisPlusProperty myBatisPlusProperty,
                             IdentificationService identificationService) {
        this.myBatisPlusProperty = myBatisPlusProperty;
        this.identificationService = identificationService;
    }

    /**
     * @return 获取租户编号
     */
    @Override
    public Expression getTenantId() {
        // 如果没有登录，不做租户过滤
        try {
            if (!identificationService.isLogin()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return new StringValue(
                String.valueOf(identificationService.getCurrentUser().getTenantCode())
        );
    }

    /**
     * @return 获取租户字段名称
     */
    @Override
    public String getTenantIdColumn() {
        return myBatisPlusProperty.getTenant().getColumnName();
    }

    /**
     * 设置不过滤租户的数据表
     *
     * @param tableName 表名
     * @return 是否过滤
     */
    @Override
    public boolean ignoreTable(String tableName) {
        // 没有登录不做租户过滤
        try {
            if (!identificationService.isLogin()) {
                return true;
            }
        } catch (Exception e) {
            log.error("获取当前登录用户失败", e);
            return true;
        }
        // 超级管理员和系统管理员不做租户过滤
        final CurrentUser currentUser = identificationService.getCurrentUser();
        // 提取当前用户的角色名称集合
        final List<String> currentUserRoleNames = currentUser.getRoles()
                .stream()
                .map(CurrentUserRole::getName)
                .toList();
        // 创建不进行租户过滤的角色名称集合
        final Set<String> ignoreRoles = Set.of(SystemRole.SUPER_ADMIN.getDesc(), SystemRole.SYSTEM_ADMIN.getDesc());
        if (currentUserRoleNames.stream().anyMatch(ignoreRoles::contains)) {
            return true;
        }
        // 如果开启了租户忽略不做租户过滤
        if (ObjectUtils.isNotEmpty(ThreadLocalUtil.get(TenantPlusConst.THREAD_LOCAL_KEY))) {
            return true;
        }
        return myBatisPlusProperty.getTenant().getIgnoresTables().contains(tableName);
    }

    /**
     * 认证的业务处理接口
     */
    private final IdentificationService identificationService;

    /**
     * MybatisPlus的自定义属性对象
     */
    private final MyBatisPlusProperty myBatisPlusProperty;

}
