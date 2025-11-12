package cc.xuepeng.ray.framework.sdk.auth.service.impl;

import cc.xuepeng.ray.framework.sdk.auth.exception.SessionUserNotFoundException;
import cc.xuepeng.ray.framework.sdk.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.sdk.auth.service.IdentificationService;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

/**
 * SaToken的业务处理实现类
 * 实现了IdentificationService接口，为ApiLog提供获取登录用户能力
 *
 * @author xuepeng
 */
@Component
@Slf4j
public class SaTokenServiceImpl implements IdentificationService {

    /**
     * Session Key
     */
    private static final String SESSION_KEY = "user";

    /**
     * 登录
     *
     * @param currentUser 当前登录用户
     * @return 访问令牌
     */
    public String login(final CurrentUser currentUser) {
        StpUtil.login(currentUser.getCode());
        StpUtil.getSession().set(SESSION_KEY, currentUser);
        return StpUtil.getTokenValue();
    }


    /**
     * @return 当前用户是否登录
     */
    @Override
    public boolean isLogin() {
        return StpUtil.isLogin();
    }

    /**
     * @return 获取当前登录用户的编号
     */
    @Override
    public CurrentUser getCurrentUser() {
        final Object result = StpUtil.getSession().get(SESSION_KEY);
        if (ObjectUtils.isEmpty(result)) {
            throw new SessionUserNotFoundException("未登录无法执行该操作");
        }
        return (CurrentUser) result;
    }

    /**
     * 登出
     */
    @Override
    public void logout() {
        if (StpUtil.isLogin()) {
            StpUtil.logout();
        }
    }

}
