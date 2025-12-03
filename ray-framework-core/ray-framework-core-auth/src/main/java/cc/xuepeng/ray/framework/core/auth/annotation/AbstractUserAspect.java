package cc.xuepeng.ray.framework.core.auth.annotation;

import cc.xuepeng.ray.framework.core.auth.service.IdentificationService;
import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Collection;

public abstract class AbstractUserAspect {

    /**
     * 设置当前登录人的相关信息
     *
     * @param baseDto BaseDto对象
     */
    abstract void doSetCurrentInfo(final BaseDto baseDto);

    /**
     * 设置本次操作的创建人
     * 1. 如果参数是BaseDto类型，则设置创建人信息
     * 2. 如果参数是Collection类型，则递归设置每个元素的创建人信息
     *
     * @param arg 方法参数
     */
    protected void setCurrentUserInfo(final Object arg) {
        // 如果参数是BaseDto类型，则设置创建人信息
        if (arg instanceof BaseDto dto) {
            this.setCurrentInfo(dto);
            return;
        }
        // 如果参数是Collection类型，则递归设置每个元素的创建人信息
        if (arg instanceof Collection<?> c) {
            for (Object obj : c) {
                setCurrentUserInfo(obj);
            }
        }
    }

    /**
     * 设置当前登录人、租户和部门信息的模板方法
     *
     * @param baseDto BaseDto对象
     */
    private void setCurrentInfo(final BaseDto baseDto) {
        this.doSetCurrentInfo(baseDto);
        // TODO 是否开启租户插件
        this.setTenantInfo(baseDto);
        this.setDeptInfo(baseDto);
    }

    private void setTenantInfo(final BaseDto baseDto) {
        // 如果当前登录人是管理员，且没有指定租户编号，则设置为当前登录人所属的租户编号
        if (identificationService.isAdmin()) {
            if (ObjectUtils.isEmpty(baseDto.getTenantCode())) {
                baseDto.setTenantCode(identificationService.getCurrentUser().getTenantCode());
            }
        }
        // 如果当前登录人不是管理员，则设置租户编号为null
        else {
            baseDto.setTenantCode(null);
        }
    }

    private void setDeptInfo(final BaseDto baseDto) {
        if (ObjectUtils.isEmpty(baseDto.getDeptCode())) {
            baseDto.setDeptCode(identificationService.getCurrentUser().getDeptCode());
        }
    }

    /**
     * 身份认证业务处理接口
     */
    @Resource
    private IdentificationService identificationService;

}
