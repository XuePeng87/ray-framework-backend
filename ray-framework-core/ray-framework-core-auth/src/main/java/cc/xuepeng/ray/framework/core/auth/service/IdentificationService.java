package cc.xuepeng.ray.framework.core.auth.service;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;

/**
 * 认证的业务处理接口
 *
 * @author xuepeng
 */
public interface IdentificationService {

    /**
     * 登录
     *
     * @param currentUser 当前登录用户
     * @return 访问令牌
     */
    String login(final CurrentUser currentUser);

    /**
     * @return 当前用户是否登录
     */
    boolean isLogin();

    /**
     * @return 获取当前登录用户的访问令牌
     */
    String getToken();

    /**
     * @return 获取当前登录用户的编号
     */
    CurrentUser getCurrentUser();

     /**
     * @return 当前登录用户是否是管理员
     */
    boolean isAdmin();

    /**
     * 登出
     */
    void logout();

}
