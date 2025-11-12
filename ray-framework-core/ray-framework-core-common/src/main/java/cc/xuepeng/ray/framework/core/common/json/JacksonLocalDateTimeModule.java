package cc.xuepeng.ray.framework.core.common.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * JacksonLocalDateTimeModule 类用于自定义 Jackson 对 LocalDateTime 类型的序列化和反序列化行为
 * 在使用 Jackson 序列化对象时，该类会将 LocalDateTime 类型的对象序列化成毫秒数，
 * 并在反序列化时将毫秒数转换回 LocalDateTime 对象
 * 这些转换操作均基于系统默认时区进行
 *
 * @author xuepeng
 */
public class JacksonLocalDateTimeModule {

    /**
     * 静态成员变量，用于存储自定义的 JavaTimeModule 实例，该实例包含了针对 LocalDateTime 的序列化和反序列化配置
     */
    private static final JavaTimeModule JACKSON_LOCAL_DATE_TIME_MODULE;

    static {
        // 静态初始化块，用于初始化 JACKSON_LOCAL_DATE_TIME_MODULE 变量
        JACKSON_LOCAL_DATE_TIME_MODULE = new JavaTimeModule();

        // 获取系统默认时区
        final ZoneOffset zoneOffset = OffsetDateTime.now().getOffset();

        // 为 LocalDateTime 类型添加自定义的序列化器
        JACKSON_LOCAL_DATE_TIME_MODULE.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                // 将 LocalDateTime 转换为系统默认时区下的毫秒数，并写入 JSON
                jsonGenerator.writeNumber(localDateTime.toInstant(zoneOffset).toEpochMilli());
            }
        });

        // 为 LocalDateTime 类型添加自定义的反序列化器
        JACKSON_LOCAL_DATE_TIME_MODULE.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
                // 从 JSON 中读取毫秒数，并转换为系统默认时区下的 LocalDateTime 对象
                final long timestamp = jsonParser.getLongValue();
                return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, zoneOffset);
            }
        });
    }

    /**
     * 私有构造函数，防止外部实例化该类，因为该类提供了单例模式
     */
    private JacksonLocalDateTimeModule() {
    }

    /**
     * 获取单例的 JavaTimeModule 实例，该实例包含了针对 LocalDateTime 的自定义序列化和反序列化配置
     *
     * @return 返回配置好的 JavaTimeModule 实例
     */
    public static JavaTimeModule getInstance() {
        return JACKSON_LOCAL_DATE_TIME_MODULE;
    }

}