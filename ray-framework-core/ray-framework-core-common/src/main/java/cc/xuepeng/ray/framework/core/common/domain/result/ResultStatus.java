package cc.xuepeng.ray.framework.core.common.domain.result;

/**
 * Result状态的接口
 *
 * @author xuepeng
 */

public interface ResultStatus {

    /**
     * @return 获得状态编号
     */
    int getCode();

    /**
     * @return 获得状态描述
     */
    String getDesc();

}
