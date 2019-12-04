package com.mengya.security.validate.verification;

import com.mengya.security.validate.code.ValidateCode;
import com.mengya.security.validate.enums.ValidateCodeKeyPrefixEnum;
import com.mengya.security.validate.enums.ValidateCodeTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Session方式（适合不跨域的情况）
 *
 * @author TongWei.Chen 2018-04-09 20:14:03
 */
public class SessionValidateCodeRepository implements ValidateCodeRepository {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * session，存验证码
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeTypeEnum validateCodeType) {
        this.sessionStrategy.setAttribute(request, getSessionKey(validateCodeType), validateCode);
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeTypeEnum validateCodeType) {
        return (ValidateCode) this.sessionStrategy.getAttribute(request, getSessionKey(validateCodeType));
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeTypeEnum validateCodeType) {
        this.sessionStrategy.removeAttribute(request, getSessionKey(validateCodeType));
    }

    /**
     * 获取sessionKey
     *
     * @return
     */
    private String getSessionKey(ValidateCodeTypeEnum validateCodeType) {
        logger.info("sessionKey：【{}】", ValidateCodeKeyPrefixEnum.SESSION_KEY_PREFIX.getPrefixKey() + validateCodeType.toString().toUpperCase());
        return ValidateCodeKeyPrefixEnum.SESSION_KEY_PREFIX.getPrefixKey() + validateCodeType.toString().toUpperCase();
    }

}
