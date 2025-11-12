package cc.xuepeng.ray.framework.core.common.domain.enums;

/**
 * 通用枚举接口
 *
 * @author xuepeng
 */
public interface BaseEnum {

    /**
     * @return 获取枚举编号
     */
    Integer getCode();

    /**
     * 根据code值获取的对应枚举
     * @param code 编号
     * @param enumClass 枚举类型
     * @return 编号对应的枚举
     * @param <T> 枚举类
     */
    static <T extends Enum<T> & BaseEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T enumConstant : enumClass.getEnumConstants()) {
            if (enumConstant.getCode().equals(code)) {
                return enumConstant;
            }
        }
        return null;
    }

}
