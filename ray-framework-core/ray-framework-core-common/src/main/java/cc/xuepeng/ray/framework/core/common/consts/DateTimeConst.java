package cc.xuepeng.ray.framework.core.common.consts;

/**
 * 日期时间格式常量类
 * 提供各种常用的日期时间格式模式
 *
 * @author xuepeng
 */
public final class DateTimeConst {

    /**
     * 私有构造函数，防止实例化
     */
    private DateTimeConst() {
    }

    // ==================== 标准格式（带分隔符） ====================

    /**
     * 标准日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准日期时间格式（含毫秒）：yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 标准日期格式：yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 标准时间格式：HH:mm:ss
     */
    public static final String HH_MM_SS = "HH:mm:ss";

    /**
     * 标准时间格式（含毫秒）：HH:mm:ss.SSS
     */
    public static final String HH_MM_SS_SSS = "HH:mm:ss.SSS";

    /**
     * 年月格式：yyyy-MM
     */
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * 月日格式：MM-dd
     */
    public static final String MM_DD = "MM-dd";

    /**
     * 小时分钟格式：HH:mm
     */
    public static final String HH_MM = "HH:mm";

    // ==================== 斜杠分隔格式 ====================

    /**
     * 斜杠分隔日期时间格式：yyyy/MM/dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SLASH = "yyyy/MM/dd HH:mm:ss";

    /**
     * 斜杠分隔日期时间格式（含毫秒）：yyyy/MM/dd HH:mm:ss.SSS
     */
    public static final String YYYY_MM_DD_HH_MM_SS_SSS_SLASH = "yyyy/MM/dd HH:mm:ss.SSS";

    /**
     * 斜杠分隔日期格式：yyyy/MM/dd
     */
    public static final String YYYY_MM_DD_SLASH = "yyyy/MM/dd";

    /**
     * 斜杠分隔年月格式：yyyy/MM
     */
    public static final String YYYY_MM_SLASH = "yyyy/MM";

    /**
     * 斜杠分隔月日格式：MM/dd
     */
    public static final String MM_DD_SLASH = "MM/dd";

    // ==================== 紧凑格式（无分隔符） ====================

    /**
     * 紧凑日期格式：yyyyMMdd
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 紧凑日期时间格式：yyyyMMddHHmmss
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 紧凑日期时间格式（含毫秒）：yyyyMMddHHmmssSSS
     */
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

    /**
     * 紧凑时间格式：HHmmss
     */
    public static final String HHMMSS = "HHmmss";

    /**
     * 紧凑时间格式（含毫秒）：HHmmssSSS
     */
    public static final String HHMMSSSSS = "HHmmssSSS";

    /**
     * 紧凑年月格式：yyyyMM
     */
    public static final String YYYYMM = "yyyyMM";

    /**
     * 紧凑月日格式：MMdd
     */
    public static final String MMDD = "MMdd";

    /**
     * 紧凑小时分钟格式：HHmm
     */
    public static final String HHMM = "HHmm";

    // ==================== 中文格式 ====================

    /**
     * 中文日期时间格式：yyyy年MM月dd日 HH时mm分ss秒
     */
    public static final String YYYY_MM_DD_HH_MM_SS_CN = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 中文日期格式：yyyy年MM月dd日
     */
    public static final String YYYY_MM_DD_CN = "yyyy年MM月dd日";

    /**
     * 中文年月格式：yyyy年MM月
     */
    public static final String YYYY_MM_CN = "yyyy年MM月";

    /**
     * 中文时间格式：HH时mm分ss秒
     */
    public static final String HH_MM_SS_CN = "HH时mm分ss秒";

    // ==================== ISO 8601 格式 ====================

    /**
     * ISO 8601 标准格式：yyyy-MM-dd'T'HH:mm:ss
     */
    public static final String ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss";

    /**
     * ISO 8601 标准格式（含毫秒）：yyyy-MM-dd'T'HH:mm:ss.SSS
     */
    public static final String ISO_8601_SSS = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    /**
     * ISO 8601 标准格式（含时区）：yyyy-MM-dd'T'HH:mm:ssZ
     */
    public static final String ISO_8601_Z = "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * ISO 8601 标准格式（含毫秒和时区）：yyyy-MM-dd'T'HH:mm:ss.SSSZ
     */
    public static final String ISO_8601_SSS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

}
