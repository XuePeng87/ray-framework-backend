package cc.xuepeng.ray.framework.module.dict.service.impl;

import cc.xuepeng.ray.framework.core.common.util.ExistsUtil;
import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.core.mybatis.consts.EntityConst;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.util.PageUtil;
import cc.xuepeng.ray.framework.core.mybatis.util.QueryWrapperUtil;
import cc.xuepeng.ray.framework.module.dict.converter.SysDictItemEntityConverter;
import cc.xuepeng.ray.framework.module.dict.dto.SysDictItemDto;
import cc.xuepeng.ray.framework.module.dict.entity.SysDictItem;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemDuplicateException;
import cc.xuepeng.ray.framework.module.dict.exception.SysDictItemNotFoundException;
import cc.xuepeng.ray.framework.module.dict.repository.SysDictItemRepository;
import cc.xuepeng.ray.framework.module.dict.service.SysDictItemService;
import cc.xuepeng.ray.framework.sdk.auth.annotation.CreateUser;
import cc.xuepeng.ray.framework.sdk.auth.annotation.ModifyUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 系统字典项的业务处理实现类
 *
 * @author xuepeng
 */
@Component
public class SysDictItemServiceImpl
        extends ServiceImpl<SysDictItemRepository, SysDictItem>
        implements SysDictItemService {

    /**
     * 创建系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 是否创建成功
     */
    @Override
    @CreateUser
    public boolean create(final SysDictItemDto sysDictItemDto) {
        final String name = sysDictItemDto.getName();
        final String value = sysDictItemDto.getValue();
        if (this.checkNameExisted(StringUtils.EMPTY, name)) {
            throw new SysDictItemDuplicateException("系统字典项名称[" + name + "]已存在");
        }
        if (this.checkValueExisted(StringUtils.EMPTY, value)) {
            throw new SysDictItemDuplicateException("系统字典项值[" + value + "]已存在");
        }
        sysDictItemDto.setCode(RandomUtil.get32UUID());
        final SysDictItem sysDictItem = sysDictItemEntityConverter.dtoToEntity(sysDictItemDto);
        return super.save(sysDictItem);
    }

    /**
     * 修改系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 是否修改成功
     */
    @Override
    @ModifyUser
    public boolean update(final SysDictItemDto sysDictItemDto) {
        final String code = sysDictItemDto.getCode();
        final String name = sysDictItemDto.getName();
        final String value = sysDictItemDto.getValue();
        if (this.checkNameExisted(code, name)) {
            throw new SysDictItemDuplicateException("系统字典项名称[" + name + "]已存在");
        }
        if (this.checkValueExisted(code, value)) {
            throw new SysDictItemDuplicateException("系统字典项值[" + value + "]已存在");
        }
        final SysDictItem sysDictItem = sysDictItemEntityConverter.dtoToEntity(sysDictItemDto);
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper(code);
        return super.update(sysDictItem, wrapper);
    }

    /**
     * 根据编号删除系统字典项
     *
     * @param codes 系统字典项的编号集合
     * @return 是否删除成功
     */
    @Override
    public boolean deleteByCodes(final List<String> codes) {
        if (CollectionUtils.isEmpty(codes)) {
            return Boolean.TRUE;
        }
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        wrapper.lambda().in(SysDictItem::getCode, codes);
        return super.remove(wrapper);
    }

    /**
     * 根据编号查询系统字典项
     *
     * @param code 编号
     * @return 系统字典项的数据传输对象
     */
    @Override
    public SysDictItemDto findByCode(final String code) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper(code);
        final SysDictItem sysDictItem = super.getOne(wrapper, QueryConst.QUERY_NULL_THROW_EX);
        if (ObjectUtils.isEmpty(sysDictItem)) {
            throw new SysDictItemNotFoundException("无法根据编号[" + code + "]查询到系统字典项");
        }
        return sysDictItemEntityConverter.entityToDto(sysDictItem);
    }

    /**
     * 根据系统字典编号查询系统字典项
     *
     * @param dictValue 所属字典
     * @return 系统字典项的数据传输对象集合
     */
    @Override
    public List<SysDictItemDto> findByDictValue(final String dictValue) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysDictItem> lambda = wrapper.lambda();
        lambda.eq(SysDictItem::getDictValue, dictValue);
        final List<SysDictItem> sysDictItems = super.list(wrapper);
        return sysDictItemEntityConverter.entityListToDtoList(sysDictItems);
    }

    /**
     * 分页查询系统字典项
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 系统字典项的数据传输对象集合
     */
    @Override
    public Page<SysDictItemDto> pageByCondition(final SysDictItemDto sysDictItemDto) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper(sysDictItemDto);
        final Page<SysDictItem> page = PageUtil.createPage(sysDictItemDto);
        final Page<SysDictItem> sysDictItems = super.page(page, wrapper);
        return sysDictItemEntityConverter.entityPageToDtoPage(sysDictItems);
    }

    /**
     * 检测系统字典项名称是否已存在
     *
     * @param code 编号
     * @param name 名称
     * @return 系统字典项名称是否已存在
     */
    private boolean checkNameExisted(final String code, final String name) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        final List<SysDictItem> sysDicts = super.list(wrapper.lambda().eq(SysDictItem::getName, name));
        return ExistsUtil.exists(
                sysDicts,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * 检测系统字典项值是否已存在
     *
     * @param code  编号
     * @param value 字典值
     * @return 系统字典项值是否已存在
     */
    private boolean checkValueExisted(final String code, final String value) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        final List<SysDictItem> sysDicts = super.list(wrapper.lambda().eq(SysDictItem::getValue, value));
        return ExistsUtil.exists(
                sysDicts,
                StringUtils.isBlank(code) ? StringUtils.EMPTY : code, EntityConst.CODE
        );
    }

    /**
     * @return 创建QueryWrapper
     */
    private QueryWrapper<SysDictItem> createQueryWrapper() {
        return QueryWrapperUtil.createQueryWrapper();
    }

    /**
     * 创建带编号的QueryWrapper
     *
     * @param code 编号
     * @return 带编号的QueryWrapper
     */
    private QueryWrapper<SysDictItem> createQueryWrapper(final String code) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        final LambdaQueryWrapper<SysDictItem> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(code), SysDictItem::getCode, code);
        return wrapper;
    }

    /**
     * 创建带条件的QueryWrapper
     *
     * @param sysDictItemDto 系统字典项的数据传输对象
     * @return 带条件的QueryWrapper
     */
    private QueryWrapper<SysDictItem> createQueryWrapper(final SysDictItemDto sysDictItemDto) {
        final QueryWrapper<SysDictItem> wrapper = this.createQueryWrapper();
        final SysDictItem sysDict = sysDictItemEntityConverter.dtoToEntity(sysDictItemDto);
        final LambdaQueryWrapper<SysDictItem> lambda = wrapper.lambda();
        lambda.eq(StringUtils.isNotBlank(sysDict.getDictValue()), SysDictItem::getDictValue, sysDict.getDictValue());
        lambda.like(StringUtils.isNotBlank(sysDict.getName()), SysDictItem::getName, sysDict.getName());
        return wrapper;
    }

    /**
     * 系统字典项实体类转换接口
     */
    @Resource
    private SysDictItemEntityConverter sysDictItemEntityConverter;

}
