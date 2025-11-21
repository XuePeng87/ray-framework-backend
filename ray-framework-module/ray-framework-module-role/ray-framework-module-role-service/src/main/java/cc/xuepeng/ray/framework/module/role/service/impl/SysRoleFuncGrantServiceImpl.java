package cc.xuepeng.ray.framework.module.role.service.impl;

import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.role.entity.SysRoleFuncRelation;
import cc.xuepeng.ray.framework.module.role.repository.SysRoleFuncRelationRepository;
import cc.xuepeng.ray.framework.module.role.service.SysRoleFuncGrantService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统角色与功能关系的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysRoleFuncGrantServiceImpl
        extends ServiceImpl<SysRoleFuncRelationRepository, SysRoleFuncRelation>
        implements SysRoleFuncGrantService {

    /**
     * 保存系统角色与功能的关系
     *
     * @param roleCode  角色编号
     * @param funcCodes 功能编号集合
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(final String roleCode, final List<String> funcCodes) {
        QueryWrapper<SysRoleFuncRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleFuncRelation::getRoleCode, roleCode);
        super.remove(wrapper);
        final List<SysRoleFuncRelation> relations = new ArrayList<>();
        funcCodes.forEach(funcCode -> {
            SysRoleFuncRelation relation = new SysRoleFuncRelation();
            relation.setRoleCode(roleCode);
            relation.setFuncCode(funcCode);
            relations.add(relation);
        });
        super.saveBatch(relations);
    }

    /**
     * 根据角色编号查询功能编号集合
     *
     * @param roleCode 角色编号
     * @return 功能编号集合
     */
    @Override
    public List<String> findFuncsByRoleCode(final String roleCode) {
        QueryWrapper<SysRoleFuncRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleFuncRelation::getRoleCode, roleCode);
        List<SysRoleFuncRelation> relations = super.list(wrapper);
        List<String> funcCodes = new ArrayList<>();
        relations.forEach(relation -> funcCodes.add(relation.getFuncCode()));
        return funcCodes;
    }

    /**
     * 根据角色编号查询功能编号集合
     *
     * @param roleCode 角色编号集合
     * @return 功能编号集合
     */
    @Override
    public List<String> findFuncsByRoleCodes(final List<String> roleCode) {
        if (CollectionUtils.isEmpty(roleCode)) {
            return new ArrayList<>();
        }
        QueryWrapper<SysRoleFuncRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().in(SysRoleFuncRelation::getRoleCode, roleCode);
        List<SysRoleFuncRelation> relations = super.list(wrapper);
        List<String> funcCodes = new ArrayList<>();
        relations.forEach(relation -> funcCodes.add(relation.getFuncCode()));
        return funcCodes;
    }

    /**
     * 根据功能编号查询角色编号集合
     *
     * @param funcCode 功能编号
     * @return 角色编号集合
     */
    @Override
    public List<String> findRolesByFuncCode(final String funcCode) {
        QueryWrapper<SysRoleFuncRelation> wrapper = this.createQueryWrapper();
        wrapper.lambda().eq(SysRoleFuncRelation::getFuncCode, funcCode);
        List<SysRoleFuncRelation> relations = super.list(wrapper);
        List<String> roleCodes = new ArrayList<>();
        relations.forEach(relation -> roleCodes.add(relation.getRoleCode()));
        return roleCodes;
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysRoleFuncRelation> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

}
