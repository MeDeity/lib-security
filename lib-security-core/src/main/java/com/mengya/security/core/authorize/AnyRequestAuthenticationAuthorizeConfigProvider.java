package com.mengya.security.core.authorize;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;
/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@Component
@Order(Integer.MAX_VALUE - 10)
public class AnyRequestAuthenticationAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Override
    public void config(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
    }
}
