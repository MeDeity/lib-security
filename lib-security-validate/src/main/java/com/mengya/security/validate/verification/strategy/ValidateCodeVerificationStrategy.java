package com.mengya.security.validate.verification.strategy;

import com.mengya.security.validate.enums.ValidateCodeTypeEnum;
import com.mengya.security.validate.verification.ValidateCodeRepository;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码校验接口
 *
 * @author chentongwei@bshf360.com 2018-05-28 15:46
 */
public interface ValidateCodeVerificationStrategy {

    /**
     * 校验验证码
     *
     * @param validateCodeRepository：验证码存取删接口
     * @param request：请求
     * @param validateCodeType：验证码类型
     */
    void verification(ValidateCodeRepository validateCodeRepository, ServletWebRequest request, ValidateCodeTypeEnum validateCodeType);
}
