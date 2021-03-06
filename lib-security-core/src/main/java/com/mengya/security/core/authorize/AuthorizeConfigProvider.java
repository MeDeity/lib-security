package com.mengya.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * 授权配置策略
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public interface AuthorizeConfigProvider {

    void config(HttpSecurity httpSecurity) throws Exception;
}
