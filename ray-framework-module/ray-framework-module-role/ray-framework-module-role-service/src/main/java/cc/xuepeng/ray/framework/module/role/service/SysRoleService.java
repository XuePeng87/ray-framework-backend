package cc.xuepeng.ray.framework.module.role.service;

import cc.xuepeng.ray.framework.module.role.dto.SysRoleDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 系统角色的业务处理接口
 *
 * @author xuepeng
 */
public interface SysRoleService {

    /**
     * 创建系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysRoleDto sysRoleDto);

    /**
     * 修改系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysRoleDto sysRoleDto);

    /**
     * 删除系统角色
     *
     * @param code 系统角色的编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据主键查询系统角色
     *
     * @param code 系统角色的编号
     * @return 系统角色的数据传输对象
     */
    SysRoleDto findByCode(final String code);

    /**
     * 根据主键查询系统角色
     *
     * @param codes 系统角色的编号集合
     * @return 系统角色的数据传输对象集合
     */
    List<SysRoleDto> findByCodes(final List<String> codes);

    /**
     * 根据条件查询系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 系统角色的数据传输对象集合
     */
    List<SysRoleDto> listByCondition(final SysRoleDto sysRoleDto);

    /**
     * 根据条件分页查询系统角色
     *
     * @param sysRoleDto 系统角色的数据传输对象
     * @return 系统角色的数据传输对象集合
     */
    Page<SysRoleDto> pageByCondition(final SysRoleDto sysRoleDto);

}
