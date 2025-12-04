package cc.xuepeng.ray.framework.core.auth.annotation;

import cc.xuepeng.ray.framework.core.auth.model.CurrentUser;
import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import jakarta.annotation.Resource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 设置修改人的切面类
 * 用于在方法调用时，获取当前登录人，用作ModifyUser注解
 *
 * @author xuepeng
 */
@Aspect
@Component
public class ModifyUserAspect extends AbstractUserAspect {

    /**
     * 设置当前登录人的相关信息
     *
     * @param baseDto BaseDto对象
     */
    @Override
    public void setUserInfo(BaseDto baseDto) {
        final CurrentUser currentUser = identificationService.getCurrentUser();
        baseDto.setModifyUser(currentUser.getCode());
    }

    /**
     * 设置修改人
     */
    @Pointcut("@annotation(cc.xuepeng.ray.framework.core.auth.annotation.ModifyUser)")
    private void modifyUser() {
        // 创建修改人
    }

    /**
     * 设置本次操作的修改人
     *
     * @param joinPoint 连接点
     */
    @Before("modifyUser()")
    public void doBefore(final JoinPoint joinPoint) {
        for (final Object arg : joinPoint.getArgs()) {
            if (arg instanceof BaseDto dto) {
                super.setAuthInfo(dto);
            }
        }
    }

    /**
     * 身份认证业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

}
