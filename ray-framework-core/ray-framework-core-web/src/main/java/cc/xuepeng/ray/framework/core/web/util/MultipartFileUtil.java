package cc.xuepeng.ray.framework.core.web.util;

import cc.xuepeng.ray.framework.core.common.enums.FileType;
import cc.xuepeng.ray.framework.core.common.exception.FileUtilException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

/**
 * MultipartFile对象的工具类
 *
 * @author xuepeng
 */
@Slf4j
public class MultipartFileUtil {

    /**
     * 构造函数
     */
    private MultipartFileUtil() {
    }


    /**
     * 校验文件安全性
     *
     * @param file 文件
     * @return 是否安全
     */
    public static boolean validate(final MultipartFile file) {
        // 获取文件后缀名
        final String fileName = file.getName();
        final String fileExtName = StringUtils.lowerCase(FilenameUtils.getExtension(fileName));
        // 获取文件类型
        final FileType fileType = FileType.getCodeByDesc(fileExtName);
        // 如果后缀名不在文件类型支持列表中，验证失败
        if (ObjectUtils.isEmpty(fileType)) {
            log.info("文件类型校验失败，系统不支持.{}类型的文件", fileExtName);
            return Boolean.FALSE;
        }
        // 进行文件字节码校验
        final String fileTypeCode = getFileTypeCode(file);
        if (StringUtils.isEmpty(fileType.getCode()) || fileType.getCode().equals(fileTypeCode)) {
            return true;
        } else {
            log.info("文件类型校验失败，.{}类型的文件的字节码不正确", fileExtName);
            return false;
        }
    }

    /**
     * 校验文件安全性
     *
     * @param file  文件
     * @param types 类型
     * @return 是否安全
     */
    public static boolean validate(final MultipartFile file, final FileType[] types) {
        // 获取文件后缀名
        final String fileName = file.getOriginalFilename();
        final String fileExtName = StringUtils.lowerCase(FilenameUtils.getExtension(fileName));
        // 获取文件类型
        final FileType fileType = FileType.getCodeByDesc(fileExtName);
        // 判断文件类型是否在系统允许的类型列表中
        if (ObjectUtils.isEmpty(fileType)) {
            return Boolean.FALSE;
        }
        // 判断文件类型是否在本次检测的支持列表中
        boolean passed = false;
        for (FileType type : types) {
            if (type == fileType) {
                passed = true;
                break;
            }
        }
        if (!passed) {
            log.info("文件类型不匹配，系统不支持.{}类型的文件", fileExtName);
            return Boolean.FALSE;
        }
        // 进行文件字节码校验
        final String fileTypeCode = getFileTypeCode(file);
        if (StringUtils.isEmpty(fileType.getCode()) || fileType.getCode().equals(fileTypeCode)) {
            return true;
        } else {
            log.info("文件类型校验失败，.{}类型的文件的字节码不正确", fileExtName);
            return false;
        }
    }

    /**
     * 把MultipartFile转为File
     *
     * @param file MultipartFile
     * @return File
     */
    public static File convertToFile(final MultipartFile file) {
        File toFile = null;
        if (ObjectUtils.isNotEmpty(file)) {
            try (InputStream ins = file.getInputStream();) {
                toFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
                inputStreamToFile(ins, toFile);
            } catch (IOException e) {
                log.error("MultipartFile转为File失败，", e);
            }
        }
        return toFile;
    }


    /**
     * 获取文件的字节码
     * 读取文件前4位字节，转换成16进制
     *
     * @param file 文件
     * @return 文件的字节码
     */
    private static String getFileTypeCode(final MultipartFile file) {
        try (InputStream fis = file.getInputStream()) {
            // 读取文件的前4个字节
            byte[] bytes = new byte[4];
            int count = fis.read(bytes);
            if (count == 4) {
                // 将字节转换为十六进制字符串
                final StringBuilder sb = new StringBuilder();
                for (byte b : bytes) {
                    int value = b & 0xFF; // 取低8位
                    String hex = Integer.toHexString(value).toUpperCase(); // 转换为大写的十六进制字符串
                    if (hex.length() < 2) {
                        sb.append("0"); // 不足两位的补0
                    }
                    sb.append(hex);
                }
                return sb.toString();
            } else {
                return StringUtils.EMPTY;
            }
        } catch (IOException e) {
            throw new FileUtilException(e);
        }
    }

    /**
     * 获取流文件
     *
     * @param ins  InputStream
     * @param file File文件
     */
    private static void inputStreamToFile(final InputStream ins, final File file) {
        try (final OutputStream os = new FileOutputStream(file);) {
            int bytesRead = 0;
            final byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, buffer.length)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            ins.close();
        } catch (Exception e) {
            log.error("获取流文件失败，", e);
        }
    }

}
