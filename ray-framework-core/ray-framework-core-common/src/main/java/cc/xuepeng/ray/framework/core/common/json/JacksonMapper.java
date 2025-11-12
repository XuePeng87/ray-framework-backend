package cc.xuepeng.ray.framework.core.common.json;

import cc.xuepeng.ray.framework.core.common.consts.DateTimeConst;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Locale;
import java.util.TimeZone;

/**
 * JacksonMapper 类用于创建和配置 Jackson 的 ObjectMapper 实例
 * 通过枚举单例模式，确保整个应用中只有一个 ObjectMapper 实例被使用
 * 该实例经过一系列配置，以支持特定的日期格式、时区设置以及 JSON 解析特性
 *
 * @author xuepeng
 */
public class JacksonMapper {

    /**
     * OBJECT_MAPPER：单例的 ObjectMapper 实例，用于 JSON 的序列化和反序列化
     */
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        // 静态初始化块，用于初始化 OBJECT_MAPPER 实例并进行配置
        OBJECT_MAPPER = new ObjectMapper();

        // 设置 ObjectMapper 使用操作系统默认时区
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault()));

        // 设置日期格式，用于日期值的序列化和反序列化
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat(DateTimeConst.YYYY_MM_DD_HH_MM_SS, Locale.CHINA));

        // 配置 ObjectMapper 允许解析 Java/C/C++ 风格的注释
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_JAVA_COMMENTS.mappedFeature(), Boolean.TRUE);

        // 允许使用不带引号的字段名（尽管 JSON 规范不允许，但某些 JavaScript 环境允许）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), Boolean.TRUE);

        // 允许使用 YAML 风格的注释（以 "#" 开头）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_YAML_COMMENTS.mappedFeature(), Boolean.TRUE);

        // 允许使用单引号来引用字符串（尽管 JSON 规范使用双引号）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), Boolean.TRUE);

        // 允许 JSON 字符串包含未转义的控制字符（尽管这通常不推荐）
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), Boolean.TRUE);

        // 允许在数组或对象的最后一个元素后尾随逗号
        OBJECT_MAPPER.configure(JsonReadFeature.ALLOW_TRAILING_COMMA.mappedFeature(), Boolean.TRUE);

        // 禁用将日期序列化为时间戳的功能
        OBJECT_MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 配置 ObjectMapper 在序列化时将日期键作为文本值（ISO-8601 格式）而不是时间戳
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, Boolean.FALSE);

        // 在反序列化时，遇到未知属性不会导致失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);

        // 注册自定义的 JacksonLocalDateTimeModule，以支持 Java 8 日期时间的序列化和反序列化
        OBJECT_MAPPER.registerModule(JacksonLocalDateTimeModule.getInstance());
    }

    /**
     * 私有构造函数，防止外部实例化该类，因为该类提供单例模式
     */
    private JacksonMapper() {
    }

    /**
     * 获取单例的 ObjectMapper 实例
     *
     * @return 返回配置好的 ObjectMapper 实例
     */
    public static ObjectMapper getInstance() {
        return OBJECT_MAPPER;
    }

}