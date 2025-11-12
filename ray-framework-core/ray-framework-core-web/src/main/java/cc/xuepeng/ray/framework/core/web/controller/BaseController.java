package cc.xuepeng.ray.framework.core.web.controller;

import cc.xuepeng.ray.framework.core.web.util.WebUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller的父类
 * 封装了Controller中常用的方法
 *
 * @author xuepeng
 */
@Getter
@Slf4j
@RestController
public class BaseController {

    /**
     * @return 获取请求IP地址
     */
    public String getRequestIp() {
        return WebUtil.getIPAddress(httpServletRequest);
    }

    /**
     * HttpServletRequest对象
     */
    @Resource
    private HttpServletRequest httpServletRequest;

}
