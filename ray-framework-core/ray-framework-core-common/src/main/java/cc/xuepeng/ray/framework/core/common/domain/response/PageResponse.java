package cc.xuepeng.ray.framework.core.common.domain.response;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页响应类
 * 包括：当前页数、每页显示的条数、总条数和查询的数据
 *
 * @param <T> 查询出的数据的类型
 * @author xuepeng
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 当前页数
     */
    private long current;

    /**
     * 每页显示多少行
     */
    private long size;

    /**
     * 总条数
     */
    private long total;

    /**
     * 本页的数据
     */
    private transient List<T> records = new ArrayList<>();

}