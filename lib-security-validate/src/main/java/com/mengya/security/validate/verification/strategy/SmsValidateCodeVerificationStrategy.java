package com.mengya.security.validate.verification.strategy;

import com.mengya.security.validate.enums.ValidateCodeParamNameEnum;
import com.mengya.security.validate.enums.ValidateCodeTypeEnum;
import com.mengya.security.validate.verification.ValidateCodeRepository;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码校验接口
 *
 * @author TongWei.Chen 2018-03-31 18:31:56
 */
public class SmsValidateCodeVerificationStrategy implements ValidateCodeVerificationStrategy {

    //没有抛出异常则代表校验通过
    @Override
    public void verification(ValidateCodeRepository validateCodeRepository, ServletWebRequest request, ValidateCodeTypeEnum validateCodeType) {
        new CommonValidateCodeVerification().verify(validateCodeRepository, request, validateCodeType, ValidateCodeParamNameEnum.DEFAULT_PARAMETER_NAME_CODE_SMS.getValue());
    }
}
