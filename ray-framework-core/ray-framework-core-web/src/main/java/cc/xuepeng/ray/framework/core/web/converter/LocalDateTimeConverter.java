package cc.xuepeng.ray.framework.core.web.converter;

import cc.xuepeng.ray.framework.core.common.consts.DateTimeConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTime转换器
 *
 * @author xuepeng
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    /**
     * 将请求参数中的时间类型数据转换成LocalDateTime对象
     *
     * @param source 转换前的数据
     * @return LocalDateTime对象
     */
    @Override
    public LocalDateTime convert(String source) {
        // 带 Z（UTC）
        if (source.endsWith("Z")) {
            Instant instant = Instant.parse(source);
            return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        }
        if (StringUtils.length(source) < 11) {
            source += " 00:00:00";
        }
        return LocalDateTime.parse(source, DateTimeFormatter.ofPattern(DateTimeConst.YYYY_MM_DD_HH_MM_SS));
    }

}
