package cc.xuepeng.ray.framework.module.role.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.role.entity.SysRoleUserRelation;
import cc.xuepeng.ray.framework.module.role.repository.SysRoleUserRelationRepository;
import cc.xuepeng.ray.framework.module.role.service.SysRoleUserGrantService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色与用户关系的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysRoleUserGrantServiceImpl
        extends ServiceImpl<SysRoleUserRelationRepository, SysRoleUserRelation>
        implements SysRoleUserGrantService {

    /**
     * 保存系统角色与用户的关系
     *
     * @param roleCode  角色编号
     * @param userCodes 用户编号集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserToRole(final String roleCode, final List<String> userCodes) {
        final QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getRoleCode, roleCode);
        super.remove(wrapper);
        final List<SysRoleUserRelation> relations = new ArrayList<>();
        userCodes.forEach(userCode -> {
            SysRoleUserRelation relation = new SysRoleUserRelation();
            relation.setRoleCode(roleCode);
            relation.setUserCode(userCode);
            relations.add(relation);
        });
        super.saveBatch(relations);
    }

    /**
     * 保存系统角色与用户的关系
     *
     * @param userCode  用户编号
     * @param roleCodes 角色编号集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRoleToUser(final String userCode, final List<String> roleCodes) {
        final QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getUserCode, userCode);
        super.remove(wrapper);
        final List<SysRoleUserRelation> relations = new ArrayList<>();
        roleCodes.forEach(roleCode -> {
            SysRoleUserRelation relation = new SysRoleUserRelation();
            relation.setRoleCode(roleCode);
            relation.setUserCode(userCode);
            relations.add(relation);
        });
        super.saveBatch(relations);
    }

    /**
     * 根据角色编号查询用户编号集合
     *
     * @param roleCode 角色编号
     * @return 用户编号集合
     */
    @Override
    public List<String> findUsersByRoleCode(final String roleCode) {
        final QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getRoleCode, roleCode);
        final List<SysRoleUserRelation> relations = super.list(wrapper);
        final List<String> userCodes = new ArrayList<>();
        relations.forEach(relation -> userCodes.add(relation.getUserCode()));
        return userCodes;
    }

    /**
     * 根据用户编号查询角色编号集合
     *
     * @param userCode 用户编号
     * @return 角色编号集合
     */
    @Override
    public List<String> findRolesByUserCode(final String userCode) {
        final QueryWrapper<SysRoleUserRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleUserRelation::getUserCode, userCode);
        final List<SysRoleUserRelation> relations = super.list(wrapper);
        final List<String> roleCodes = new ArrayList<>();
        relations.forEach(relation -> roleCodes.add(relation.getRoleCode()));
        return roleCodes;
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysRoleUserRelation> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

}
