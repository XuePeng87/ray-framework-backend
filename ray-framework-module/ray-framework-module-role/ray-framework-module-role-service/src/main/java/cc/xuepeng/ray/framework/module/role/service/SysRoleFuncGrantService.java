package cc.xuepeng.ray.framework.module.role.service;

import java.util.List;

/**
 * 系统角色与功能关系的业务处理接口
 *
 * @author xuepeng
 */
public interface SysRoleFuncGrantService {

    /**
     * 保存系统角色与功能的关系
     *
     * @param roleCode  角色编号
     * @param funcCodes 功能编号集合
     */
    void save(final String roleCode, final List<String> funcCodes);

    /**
     * 根据角色编号查询功能编号集合
     *
     * @param roleCode 角色编号
     * @return 功能编号集合
     */
    List<String> findFuncsByRoleCode(final String roleCode);

    /**
     * 根据角色编号查询功能编号集合
     *
     * @param roleCode 角色编号集合
     * @return 功能编号集合
     */
    List<String> findFuncsByRoleCodes(final List<String> roleCode);

    /**
     * 根据功能编号查询角色编号集合
     *
     * @param funcCode 功能编号
     * @return 角色编号集合
     */
    List<String> findRolesByFuncCode(final String funcCode);

}
