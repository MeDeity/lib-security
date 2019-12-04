package com.mengya.security.validate.config;

import com.mengya.security.validate.code.ValidateCodeGenerator;
import com.mengya.security.validate.code.geetest.GeetestCodeGenerator;
import com.mengya.security.validate.code.image.ImageCodeGenerator;
import com.mengya.security.validate.code.sms.DefaultSmsCodeSender;
import com.mengya.security.validate.code.sms.SmsCodeSender;
import com.mengya.security.validate.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 配置图片验证码bean
     * <p>
     * imageValidateCodeGenerator =》{@link .AbstractValidateCodeProcessor} generate() generatorName
     *
     * @return
     */
    @Bean
    /**
     * 此注解可以方便扩展，你自己可以重写一套验证码生成逻辑，而不是我内置的。
     */
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }

    /**
     * 配置图片验证码bean
     * <p>
     * geetestValidateCodeGenerator =》{@link .AbstractValidateCodeProcessor} generate() generatorName
     *
     * @return
     */
    @Bean
    /**
     * 此注解可以方便扩展，你自己可以重写一套验证码生成逻辑，而不是我内置的。
     */
    @ConditionalOnMissingBean(name = "geetestValidateCodeGenerator")
    public ValidateCodeGenerator geetestValidateCodeGenerator() {
        GeetestCodeGenerator geetestCodeGenerator = new GeetestCodeGenerator();
        geetestCodeGenerator.setSecurityProperties(securityProperties);
        return geetestCodeGenerator;
    }

    /**
     * 配置短信验证码发送bean
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        DefaultSmsCodeSender defaultSmsCodeSender = new DefaultSmsCodeSender();
        return defaultSmsCodeSender;
    }
}
