package cc.xuepeng.ray.framework.module.role.service;

import java.util.List;

/**
 * 系统角色与用户关系的业务处理接口
 *
 * @author xuepeng
 */
public interface SysRoleUserGrantService {

    /**
     * 保存系统角色与用户的关系
     *
     * @param roleCode  角色编号
     * @param userCodes 用户编号集合
     */
    void saveUserToRole(final String roleCode, final List<String> userCodes);

    /**
     * 保存系统角色与用户的关系
     *
     * @param userCode  用户编号
     * @param roleCodes 角色编号集合
     */
    void saveRoleToUser(final String userCode, final List<String> roleCodes);

    /**
     * 根据角色编号查询用户编号集合
     *
     * @param roleCode 角色编号
     * @return 用户编号集合
     */
    List<String> findUsersByRoleCode(final String roleCode);

    /**
     * 根据用户编号查询角色编号集合
     *
     * @param userCode 用户编号
     * @return 角色编号集合
     */
    List<String> findRolesByUserCode(final String userCode);

}
