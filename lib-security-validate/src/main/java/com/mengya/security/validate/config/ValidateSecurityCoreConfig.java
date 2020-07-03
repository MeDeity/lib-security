package com.mengya.security.validate.config;

import com.mengya.security.core.authorize.AuthorizeConfigManager;
import com.mengya.security.validate.constants.ValidateCodeConstants;
import com.mengya.security.validate.enums.DefaultLoginProcessingUrlEnum;
import com.mengya.security.validate.mobile.SmsCodeAuthenticationSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 验证安全核心配置
 *
 * @author chentongwei@bshf360.com 2018-05-30 14:31
 */
@ConditionalOnProperty(prefix = "core.config", value = "default", matchIfMissing = true)
@Configuration
public class ValidateSecurityCoreConfig extends WebSecurityConfigurerAdapter {
    /**
     * 失败处理器
     */
    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 成功处理器
     */
    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;
    /**
     * 验证码
     */
    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    /**
     * 短信验证配置
     */
    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage(ValidateCodeConstants.DEFAULT_UNAUTHENTICATION_URL)
            .loginProcessingUrl(DefaultLoginProcessingUrlEnum.FORM.getUrl())
            .successHandler(authenticationSuccessHandler)
            .failureHandler(authenticationFailureHandler)
            .and()
            .apply(validateCodeSecurityConfig)
            .and()
            .apply(smsCodeAuthenticationSecurityConfig)
            .and()
            // 先加上这句话，否则登录的时候会出现403错误码，Could not verify the provided CSRF token because your session was not found.
            .csrf().disable();

        // 一定要放到最后，是因为config方法里最后做了其他任何方法都需要身份认证才能访问。
        // 放到前面的话，后面在加载.antMatchers(getPermitUrls()).permitAll()的时候也会被认为无权限，
        // 因为前面已经做了其他任何方法都需要身份认证才能访问，SpringSecurity是有先后顺序的。
        authorizeConfigManager.config(http);
    }

    /**
     * Consider defining a bean of type 'org.springframework.security.authentication.AuthenticationManager' in your configuration
     * https://stackoverflow.com/questions/52243774/consider-defining-a-bean-of-type-org-springframework-security-authentication-au
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
