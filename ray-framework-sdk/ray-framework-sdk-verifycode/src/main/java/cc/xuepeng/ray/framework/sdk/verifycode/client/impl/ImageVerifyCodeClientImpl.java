package cc.xuepeng.ray.framework.sdk.verifycode.client.impl;

import cc.xuepeng.ray.framework.core.common.util.RandomUtil;
import cc.xuepeng.ray.framework.sdk.verifycode.client.ImageVerifyCodeClient;
import cc.xuepeng.ray.framework.sdk.verifycode.enums.VerifyCodeType;
import cc.xuepeng.ray.framework.sdk.verifycode.exception.VerifyCodeExpiredException;
import cc.xuepeng.ray.framework.sdk.verifycode.exception.VerifyCodeIncorrectException;
import cc.xuepeng.ray.framework.sdk.verifycode.model.ImageVerifyCode;
import cc.xuepeng.ray.framework.sdk.verifycode.property.VerifyCodeProperty;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 图片验证码的工具实现类
 *
 * @author xuepeng
 */
@Component
public class ImageVerifyCodeClientImpl implements ImageVerifyCodeClient {

    /**
     * 生成图片验证码
     *
     * @param type 验证码类型
     * @return 图片验证码
     */
    @Override
    public ImageVerifyCode generate(final VerifyCodeType type) {
        // 生成验证码
        final Captcha captcha = new ArithmeticCaptcha(
                verifyCodeProperty.getCaptchaImgWidth(),
                verifyCodeProperty.getCaptchaImgHeight(),
                verifyCodeProperty.getCaptchaLength()
        );
        final String uuid = RandomUtil.get32UUID();
        final String img = captcha.toBase64();
        final String text = captcha.text();
        // 缓存验证码
        final String key = type.getPrefix() + uuid;
        stringRedisTemplate.opsForValue().set(
                key,
                text,
                verifyCodeProperty.getExpiration()
        );
        return ImageVerifyCode.builder().uuid(uuid).img(img).build();
    }

    /**
     * 验证码是否正确
     *
     * @param uuid 唯一标识
     * @param code 验证码
     * @param type 验证码类型
     */
    @Override
    public void verify(final String uuid, final String code, final VerifyCodeType type) {
        final String key = type.getPrefix() + uuid;
        final String answer = stringRedisTemplate.opsForValue().get(key);
        // 删除验证码，验证码进行一次校验，无论对错都会删除
        stringRedisTemplate.delete(key);
        // 判断验证码是否正确
        if (StringUtils.isBlank(answer)) {
            throw new VerifyCodeExpiredException("验证码不存在或已过期");
        }
        if (StringUtils.isBlank(code) || !Strings.CI.equals(answer, code)) {
            throw new VerifyCodeIncorrectException("验证码不正确");
        }
    }

    /**
     * 验证码的配置对象
     */
    @Resource
    private VerifyCodeProperty verifyCodeProperty;

    /**
     * Redis工具
     */
    @Resource
    private StringRedisTemplate stringRedisTemplate;

}
