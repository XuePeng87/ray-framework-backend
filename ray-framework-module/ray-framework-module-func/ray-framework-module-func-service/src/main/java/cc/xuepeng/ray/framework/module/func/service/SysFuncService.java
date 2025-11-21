package cc.xuepeng.ray.framework.module.func.service;

import cc.xuepeng.ray.framework.module.func.dto.SysFuncDto;

import java.util.List;

/**
 * 系统功能的业务处理接口
 *
 * @author xuepeng
 */
public interface SysFuncService {

    /**
     * 创建系统功能
     *
     * @param sysFuncDto 系统功能的数据传输对象
     * @return 是否创建成功
     */
    boolean create(final SysFuncDto sysFuncDto);

    /**
     * 修改系统功能
     *
     * @param sysFuncDto 系统功能的数据传输对象
     * @return 是否修改成功
     */
    boolean update(final SysFuncDto sysFuncDto);

    /**
     * 根据编号删除系统功能
     *
     * @param code 编号
     * @return 是否删除成功
     */
    boolean delete(final String code);

    /**
     * 根据编号查询系统功能
     *
     * @param code 编号
     * @return 系统功能的数据传输对象
     */
    SysFuncDto findByCode(final String code);

    /**
     * 根据编号查询系统功能
     *
     * @param codes 编号集合
     * @return 系统功能的数据传输对象集合
     */
    List<SysFuncDto> findByCodes(final List<String> codes);

    /**
     * 根据条件查询系统功能并转换成树
     *
     * @param sysFuncDto 系统功能的数据传输对象树
     * @return 系统功能的数据传输对象集合
     */
    List<SysFuncDto> listByCondition(final SysFuncDto sysFuncDto);

}
