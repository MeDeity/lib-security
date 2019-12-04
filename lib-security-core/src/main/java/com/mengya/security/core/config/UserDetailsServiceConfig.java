package com.mengya.security.core.config;

import com.mengya.security.core.service.DefaultUserDetailsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户业务处理配置
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@Configuration
public class UserDetailsServiceConfig {
    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService userDetailsService() {
        return new DefaultUserDetailsService();
    }

}
