package cc.xuepeng.ray.framework.sdk.verifycode.client;

import cc.xuepeng.ray.framework.sdk.verifycode.enums.VerifyCodeType;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;

/**
 * 图片验证码的工具类
 *
 * @author xuepeng
 */
public interface ImageVerifyCodeClient {

    /**
     * 生成图片验证码
     *
     * @param type 验证码类型
     * @return 图片验证码
     */
    ImageVerifyCode generate(final VerifyCodeType type);

    /**
     * 验证码是否正确
     *
     * @param uuid 唯一标识
     * @param code 验证码
     * @param type 验证码类型
     */
    void verify(final String uuid, final String code, final VerifyCodeType type);

}
