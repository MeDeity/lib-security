package com.mengya.security.validate.enums;
/**
 * 验证码存储的前缀key，session/redis
 *
 * @author chentongwei@bshf360.com 2018-06-01 12:36
 */
public enum ValidateCodeKeyPrefixEnum {
    /**
     * 验证码放入session时的前缀
     */
    SESSION_KEY_PREFIX("SESSION_KEY_FOR_CODE_"),

    /**
     * 验证码放入redis时的前缀
     */
    REDIS_KEY_PREFIX("REDIS_KEY_FOR_CODE_")
    ;

    private String prefixKey;

    ValidateCodeKeyPrefixEnum(String prefixKey) {
        this.prefixKey = prefixKey;
    }

    public String getPrefixKey() {
        return prefixKey;
    }
}
