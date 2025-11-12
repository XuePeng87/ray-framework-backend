package cc.xuepeng.ray.framework.core.common.util;

import cc.xuepeng.ray.framework.core.common.consts.DateTimeConst;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * DateTimeUtil 类是一个日期时间工具类，提供了一系列与日期时间相关的静态方法
 * 这些方法包括获取从现在到明天的秒数、获取从现在到明天的时间区间、以及格式化日期时间等
 * 该类使用了线程局部变量来存储 SimpleDateFormat 实例，以避免多线程环境下的并发问题
 *
 * @author xuepeng
 */
public class DateTimeUtil {

    /**
     * threadLocalDateFormat 是一个 ThreadLocal 变量，用于存储 SimpleDateFormat 实例
     * 每个线程都会有一个独立的 SimpleDateFormat 实例，以避免多线程环境下的并发问题
     * 初始格式为 YYYY-MM-DD HH:MM:SS，使用系统默认的语言环境
     */
    public static final ThreadLocal<SimpleDateFormat> threadLocalDateFormat = ThreadLocal.withInitial(
            () -> new SimpleDateFormat(DateTimeConst.YYYY_MM_DD_HH_MM_SS, Locale.getDefault())
    );

    /**
     * dateTimeFormatter 是一个 DateTimeFormatter 实例，用于格式化日期时间为 YYYY-MM-DD HH:MM:SS 格式
     */
    public static final DateTimeFormatter dateTimeFormatter =
            DateTimeFormatter.ofPattern(DateTimeConst.YYYY_MM_DD_HH_MM_SS);

    /**
     * 私有构造函数，防止外部实例化该类
     * 因为该类提供的是静态方法，所以不需要实例化
     */
    private DateTimeUtil() {
    }

    /**
     * 获取从现在到明天的秒数，使用系统默认时区
     *
     * @return 返回从现在到明天的秒数
     */
    public static long getSecondFromNowToTomorrow() {
        return getSecondFromNowToTomorrow(OffsetDateTime.now().getOffset());
    }

    /**
     * 获取从现在到明天的秒数，使用自定义时区
     *
     * @param zoneOffset 自定义时区偏移量
     * @return 返回从现在到明天的秒数
     */
    public static long getSecondFromNowToTomorrow(final ZoneOffset zoneOffset) {
        final long add = 1L;
        final long now = LocalDateTime.now().toEpochSecond(zoneOffset);
        final long next = LocalDate.now().plusDays(add).atStartOfDay().toEpochSecond(zoneOffset);
        return next - now;
    }

    /**
     * 获取从现在到明天的时间区间，使用系统默认时区
     *
     * @return 返回从现在到明天的时间区间（Duration）
     */
    public static Duration getDurationToTomorrow() {
        return getDurationToTomorrow(ZoneId.systemDefault());
    }

    /**
     * 获取从现在到明天的时间区间，使用自定义时区
     *
     * @param zoneId 自定义时区 ID
     * @return 返回从现在到明天的时间区间（Duration）
     */
    public static Duration getDurationToTomorrow(final ZoneId zoneId) {
        final long add = 1L;
        final LocalDateTime now = LocalDateTime.now(zoneId);
        final LocalDateTime nextDay = LocalDate.now(zoneId)
                .plusDays(add)
                .atStartOfDay();
        // 返回从现在到明天的时间区间
        return Duration.between(now, nextDay);
    }

    /**
     * 使用 SimpleDateFormat 格式化日期时间
     *
     * @param date    需要格式化的日期时间对象
     * @param pattern 可选的日期时间格式模式，如果为空则使用默认格式
     * @return 返回格式化后的日期时间字符串
     */
    public static String formatBySimpleDateFormat(final Date date, final String... pattern) {
        SimpleDateFormat simpleDateFormat = threadLocalDateFormat.get();
        if (pattern.length > 0) {
            simpleDateFormat.applyPattern(pattern[0]);
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 使用 DateTimeFormatter 格式化 LocalDateTime 对象，使用系统默认时区
     *
     * @param localDateTime 需要格式化的 LocalDateTime 对象
     * @param pattern       可选的日期时间格式模式，如果为空则使用默认格式
     * @return 返回格式化后的日期时间字符串
     */
    public static String formatBySimpleDateFormat(final LocalDateTime localDateTime, final String... pattern) {
        if (pattern.length > 0) {
            return DateTimeFormatter.ofPattern(pattern[0]).withZone(ZoneId.systemDefault()).format(localDateTime);
        }
        return dateTimeFormatter.format(localDateTime);
    }

}