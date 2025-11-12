package cc.xuepeng.ray.framework.core.common.util;

import cc.xuepeng.ray.framework.core.common.json.JacksonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Json工具类
 *
 * @author xuepeng
 */
public class JsonUtil {

    /**
     * 创建Jackson的映射对象
     */
    private static final ObjectMapper MAPPER = JacksonMapper.getInstance();

    /**
     * 构造函数
     */
    private JsonUtil() {
    }

    /**
     * 将JsonNode转换为对象
     *
     * @param jsonNode  node
     * @param valueType 类型
     * @param <T>       对象类型
     * @return 结果
     * @throws IllegalArgumentException jsonNode对象转换对象失败
     */
    public static <T> T nodeToObj(JsonNode jsonNode, Class<T> valueType) {
        T result;
        if (Objects.isNull(jsonNode)) {
            throw new NullPointerException("jsonNode不能为空");
        }
        // 类型转换
        try {
            result = MAPPER.treeToValue(jsonNode, valueType);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("jsonNode对象转换对象失败", e);
        }
        return result;
    }

    /**
     * 将一个对象转换成Json字符串
     *
     * @param obj 要转换的对象
     * @param <T> 要转换的对象的类型
     * @return 对象的Json字符串
     */
    public static <T> String objToStr(final T obj) {
        String result;
        if (Objects.isNull(obj)) {
            throw new NullPointerException("要转换的对象不能为空");
        }
        // 判断要转换的对象是否是字符串
        // 如果是，则直接返回一个新的字符串
        // 如果不是，则通过Jackson转换成json字符串
        if (obj instanceof String) {
            result = String.valueOf(obj);
        } else {
            try {
                result = MAPPER.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException("对象转换Json字符串失败", e);
            }
        }
        return result;
    }

    /**
     * 将一个Json字符串转换成对象
     *
     * @param str   Json字符串
     * @param clazz 要转换的对象的class对象
     * @param <T>   要转换的对象的类型
     * @return 转换后的对象
     */
    public static <T> T strToObj(final String str, final Class<T> clazz) {
        checkJsonString(str);
        try {
            return MAPPER.readValue(str, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换对象失败", e);
        }
    }

    /**
     * 将一个Json字符串转换成对象
     *
     * @param str           将一个Json字符串转换成对象
     * @param typeReference 要转换的对象的class对象
     * @param <T>           要转换的对象的类型
     * @return 转换后的对象
     */
    public static <T> T strToObj(final String str, final TypeReference<T> typeReference) {
        checkJsonString(str);
        try {
            return MAPPER.readValue(str, typeReference);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换对象失败", e);
        }
    }

    /**
     * 将一个Json字符串转换成JsonNode
     *
     * @param str Json字符串
     * @return 转换后的JsonNode
     */
    public static JsonNode strToJsonNode(final String str) {
        checkJsonString(str);
        try {
            return MAPPER.readTree(str);
        } catch (IOException e) {
            throw new IllegalArgumentException("Json字符串转换JsonNode失败", e);
        }
    }

    /**
     * 将一个JsonNode转换成Map
     *
     * @param node Json对象
     * @return 转换后的JsonNode
     */
    public static Map<String, Object> jsonNodeToMap(final JsonNode node) {
        try {
            return MAPPER.convertValue(node, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("JsonNode转Map失败", e);
        }
    }

    /**
     * 将一个对象转换成JsonNode
     *
     * @param object 对象
     * @return 换转后的JsonNode
     */
    public static JsonNode objToJsonNode(final Object object) {
        return MAPPER.valueToTree(object);
    }

    /**
     * @return 创建一个ObjectNode对象
     */
    public static ObjectNode createObjectNode() {
        return MAPPER.createObjectNode();
    }

    /**
     * @return 创建一个ArrayNode对象
     */
    public static ArrayNode createArrayNode() {
        return MAPPER.createArrayNode();
    }

    /**
     * 检查Json字符串
     *
     * @param str Json字符串
     */
    private static void checkJsonString(final String str) {
        if (StringUtils.isBlank(str)) {
            throw new NullPointerException("Json字符串不能为空");
        }
    }

}
