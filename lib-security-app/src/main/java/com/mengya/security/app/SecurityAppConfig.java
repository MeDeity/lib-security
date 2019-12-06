package com.mengya.security.app;

import com.mengya.security.app.authentication.AppAuthenticationFailureHandler;
import com.mengya.security.app.authentication.AppAuthenticationSuccessHandler;
import com.mengya.security.app.properties.SecurityProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@PropertySource("classpath:security.properties")
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityAppConfig {

    @Bean(name = "authenticationSuccessHandler")
    @ConditionalOnProperty(prefix = "core.security.app.success.handler", name = "enable", matchIfMissing = true)
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    @Bean(name = "authenticationFailureHandler")
    @ConditionalOnProperty(prefix = "core.security.app.failure.handler", name = "enable", matchIfMissing = true)
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AppAuthenticationFailureHandler();
    }
}
