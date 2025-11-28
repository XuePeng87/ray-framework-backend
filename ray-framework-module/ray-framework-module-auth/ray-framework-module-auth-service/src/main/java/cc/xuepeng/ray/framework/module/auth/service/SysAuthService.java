package cc.xuepeng.ray.framework.module.auth.service;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.module.auth.dto.SysLoginDto;

/**
 * 系统认证的业务处理接口
 *
 * @author xuepeng
 */
public interface SysAuthService {

    /**
     * 系统登录
     *
     * @param sysLoginDto 系统登录的数据传输对象
     * @return 访问令牌
     */
    String login(final SysLoginDto sysLoginDto);

    /**
     * @return 获取当前登录人
     */
    CurrentUser getCurrentUser();

    /**
     * 系统登出
     */
    void logout();

}
