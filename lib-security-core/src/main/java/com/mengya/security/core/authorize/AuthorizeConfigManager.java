package com.mengya.security.core.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public interface AuthorizeConfigManager {

    void config(HttpSecurity httpSecurity) throws Exception;
}
