package cc.xuepeng.ray.framework.core.mybatis.util;

import cc.xuepeng.ray.framework.core.common.domain.dto.BaseDto;
import cc.xuepeng.ray.framework.core.mybatis.consts.QueryConst;
import cc.xuepeng.ray.framework.core.mybatis.entity.BaseEntity;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

/**
 * 分页对象工具类
 *
 * @author xuepeng
 */
public class PageUtil {

    /**
     * 构造函数
     */
    private PageUtil() {
    }

    /**
     * 创建一个MyBatis Plus分页对象
     *
     * @param dto 数据传输对象的父类
     * @param <T> 分页对象的类型
     * @return MyBatis Plus分页对象
     */
    public static <T extends BaseEntity> Page<T> createPage(final BaseDto dto) {
        // 设置分页参数
        int offset = 1;
        int limit = 20;
        if (ObjectUtils.isNotEmpty(dto.getOffset())) offset = dto.getOffset();
        if (ObjectUtils.isNotEmpty(dto.getLimit())) limit = dto.getLimit();
        final Page<T> page = new Page<>(offset, limit);
        final String sort = dto.getSort();
        // 设置排序参数
        final String regex = "\\w+";
        if (ObjectUtils.isNotEmpty(sort) && sort.matches(regex)) {
            if(Strings.CI.equalsAny(dto.getOrder(), QueryConst.ASC)) {
                page.addOrder(OrderItem.asc(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort)));
            } else {
                page.addOrder(OrderItem.desc(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, sort)));
            }
        }
        return page;
    }

}
