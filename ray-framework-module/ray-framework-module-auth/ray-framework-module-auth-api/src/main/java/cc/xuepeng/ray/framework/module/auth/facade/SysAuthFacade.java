package cc.xuepeng.ray.framework.module.auth.facade;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.module.auth.request.SysLoginRequest;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;

/**
 * 系统认证的业务处理门面接口
 */
public interface SysAuthFacade {

    /**
     * @return 创建图片验证码
     */
    ImageVerifyCode createLoginImageVerifyCode();

    /**
     * 系统登录
     *
     * @param sysLoginRequest 系统登录的请求对象
     * @return 访问令牌
     */
    String login(final SysLoginRequest sysLoginRequest);

    /**
     * @return 获取当前登录用户
     */
    CurrentUser getCurrentUser();

    /**
     * 系统登出
     */
    void logout();

}
