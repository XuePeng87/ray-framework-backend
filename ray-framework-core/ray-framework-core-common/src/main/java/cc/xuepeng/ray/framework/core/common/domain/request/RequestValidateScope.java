package cc.xuepeng.ray.framework.core.common.domain.request;

/**
 * 参数验证范围
 *
 * @author xuepeng
 */
public interface RequestValidateScope {

    /**
     * 参数校验分组：分页
     */
    public @interface page {
    }

    /**
     * 参数校验分组：列表
     */
    public @interface list {
    }

    /**
     * 参数校验分组：下拉
     */
    public @interface dropDown {
    }

    /**
     * 参数校验分组：注册
     */
    public @interface regedit {
    }

    /**
     * 参数校验分组：创建
     */
    public @interface create {
    }

    /**
     * 参数校验分组：修改
     */
    public @interface update {
    }

    /**
     * 参数校验分组：修改密码
     */
    public @interface updatePwd {
    }

    /**
     * 参数校验分组：重置密码
     */
    public @interface resetPwd {
    }

    /**
     * 参数校验分组：上传头像
     */
    public @interface avatar {
    }

    /**
     * 参数校验分组：删除
     */
    public @interface delete {
    }

    /**
     * 参数校验分组：详情
     */
    public @interface detail {
    }

    /**
     * 参数校验分组：强制退出
     */
    public @interface force {
    }

    /**
     * 参数校验分组：停用
     */
    public @interface disable {
    }

    /**
     * 参数校验分组：启用
     */
    public @interface enable {
    }

    /**
     * 参数校验分组：导出
     */
    public @interface export {
    }

}
