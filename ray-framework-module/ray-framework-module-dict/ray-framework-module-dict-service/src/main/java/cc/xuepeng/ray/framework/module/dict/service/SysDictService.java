package cc.xuepeng.ray.framework.module.dict.service;

import cc.xuepeng.ray.framework.module.dict.dto.SysDictDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 系统字典的业务处理接口
 *
 * @author xuepeng
 */
public interface SysDictService {

    /**
     * 创建系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysDictDto sysDictDto);

    /**
     * 修改系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysDictDto sysDictDto);

    /**
     * 根据编号删除系统字典
     *
     * @param codes 系统字典的编号集合
     * @return 是否删除成功
     */
    boolean deleteByCodes(final List<String> codes);

    /**
     * 根据编号查询系统字典
     *
     * @param code 系统字典的编号
     * @return 系统字典的数据传输对象
     */
    SysDictDto findByCode(final String code);

    /**
     * 根据条件分页查询系统字典
     *
     * @param sysDictDto 系统字典的数据传输对象
     * @return 系统字典的数据传输对象集合
     */
    Page<SysDictDto> pageByCondition(final SysDictDto sysDictDto);

}
