package com.mengya.security.validate.verification.strategy;

import com.mengya.security.validate.enums.ValidateCodeParamNameEnum;
import com.mengya.security.validate.enums.ValidateCodeTypeEnum;
import com.mengya.security.validate.verification.ValidateCodeRepository;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 图形验证码校验具体实现类
 *
 * @author chentongwei@bshf360.com 2018-05-28 15:50
 */
public class ImageValidateCodeVerificationStrategy implements ValidateCodeVerificationStrategy {

    @Override
    public void verification(ValidateCodeRepository validateCodeRepository, ServletWebRequest request, ValidateCodeTypeEnum validateCodeType) {
        new CommonValidateCodeVerification().verify(
                validateCodeRepository, request, validateCodeType, ValidateCodeParamNameEnum.DEFAULT_PARAMETER_NAME_CODE_IMAGE.getValue());
    }
}
