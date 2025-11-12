package cc.xuepeng.ray.framework.core.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

/**
 * 文件类型的枚举
 *
 * @author xuepeng
 */
@ToString
@Getter
@AllArgsConstructor
public enum FileType {

    // 逗号分隔值文件，通常用于存储表格数据
    CSV(StringUtils.EMPTY, "csv"),

    // Excel 97-2003工作簿文件
    XLS(StringUtils.EMPTY, "xls"),

    // Excel 2007及更高版本的工作簿文件
    XLSX(StringUtils.EMPTY, "xlsx"),

    // 3D Studio文件，用于存储3D模型
    DS3(StringUtils.EMPTY, "3ds"),

    // 音频视频交错格式文件，一种常见的视频文件格式
    AVI("41564920", "avi"),

    // Babylon.js场景文件，用于3D图形渲染
    BABYLON(StringUtils.EMPTY, "babylon"),

    // Blender 3D场景文件
    BLEND(StringUtils.EMPTY, "blend"),

    // Windows位图文件，一种常见的图像格式
    BMP("424D3E00", "bmp"),

    // Brotli压缩文件
    BR(StringUtils.EMPTY, "br"),

    // 层叠样式表文件，用于网页的样式设计
    CSS("40636861", "css"),

    // COLLADA数字资产交换文件，用于3D图形数据的交换
    DAE(StringUtils.EMPTY, "dae"),

    // 一般数据文件，没有特定的格式
    DATA(StringUtils.EMPTY, "data"),

    // 嵌入式OpenType字体文件
    EOT(StringUtils.EMPTY, "eot"),

    // Autodesk FBX文件，用于3D图形数据的交换
    FBX(StringUtils.EMPTY, "fbx"),

    // 图形交换格式文件，一种常见的图像格式
    GIF("47494638", "gif"),

    // GL传输格式文件，用于3D图形的传输
    GLTF(StringUtils.EMPTY, "gltf"),

    // GL二进制文件，GLTF文件的二进制版本
    GLB(StringUtils.EMPTY, "glb"),

    // 联合图像专家组文件，一种常见的图像格式
    JPEG("FFD8FFE0", "jpeg"),

    // 联合图像专家组文件，jpg是jpeg的另一种常见扩展名
    JPG("FFD8FFE0", "jpg"),

    // JavaScript文件，用于网页的脚本编程
    JS("76617220", "js"),

    // JavaScript对象表示法文件，用于数据交换
    JSON(StringUtils.EMPTY, "json"),

    // LESS样式表文件，扩展了CSS的功能
    LESS(StringUtils.EMPTY, "less"),

    // 内存文件，可能用于特定应用程序的内存数据交换
    MEM(StringUtils.EMPTY, "mem"),

    // 3ds Max场景文件，用于3D图形设计
    MAX(StringUtils.EMPTY, "max"),

    // Maya ASCII场景文件，用于3D图形设计
    MA(StringUtils.EMPTY, "ma"),

    // Maya二进制场景文件，用于3D图形设计
    MB(StringUtils.EMPTY, "mb"),

    // MPEG-4第14部分文件，一种常见的视频文件格式
    MP4("00000018", "mp4"),

    // Wavefront OBJ文件，用于存储3D模型
    OBJ(StringUtils.EMPTY, "obj"),

    // OpenType字体文件
    OTF(StringUtils.EMPTY, "otf"),

    // 可移植网络图形文件，一种常见的图像格式
    PNG("89504E47", "png"),

    // RealMedia文件，一种常见的视频文件格式
    RM("2E524D46", "rm"),

    // RealMedia可变比特率文件，一种常见的视频文件格式
    RMVB("2E524D46", "rmvb"),

    // 立体光刻文件，用于3D打印
    STL(StringUtils.EMPTY, "stl"),

    // TrueType字体文件
    TTF(StringUtils.EMPTY, "ttf"),

    // Unity Web Player文件，用于Unity游戏的网页发布
    UNITYWEB(StringUtils.EMPTY, "unityweb"),

    // WebAssembly文件，一种用于网页的二进制指令格式
    WASM(StringUtils.EMPTY, "wasm"),

    // WebP图像文件，一种支持无损和有损压缩的图像格式
    WEBP("52494646", "webp"),

    // Windows Media Video文件，一种常见的视频文件格式
    WMV("3026B275", "wmv"),

    // Web开放字体格式文件
    WOFF(StringUtils.EMPTY, "woff"),

    // Web开放字体格式2.0文件
    WOFF2(StringUtils.EMPTY, "woff2"),

    // 可缩放矢量图形文件，用于2D图形的矢量表示
    SVG(StringUtils.EMPTY, "svg"),

    // Shockwave Flash文件，一种常见的动画文件格式
    SWF(StringUtils.EMPTY, "swf"),

    // 可扩展3D文件，用于3D图形的表示
    X3D(StringUtils.EMPTY, "x3d"),

    // ZIP压缩文件，用于文件的压缩和归档
    ZIP(StringUtils.EMPTY, "zip"),

    // Adobe Photoshop文档文件，用于图像处理
    PSD("38425053", "psd"),

    // WebM视频文件，一种基于VP8/VP9视频编码和Vorbis音频编码的视频文件格式
    WEBM("5745424D", "webm");

    /**
     * 根据文件后缀名获取字节码
     *
     * @param extName 后缀名
     * @return 字节码
     */
    public static FileType getCodeByDesc(final String extName) {
        for (FileType e : values()) {
            if (Strings.CI.equals(e.extName, extName)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 文件编号（魔数），用于唯一标识文件类型
     */
    private final String code;

    /**
     * 文件后缀，用于标识文件的类型
     */
    private final String extName;

}