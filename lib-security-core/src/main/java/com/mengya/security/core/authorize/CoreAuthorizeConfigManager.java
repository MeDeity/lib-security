package com.mengya.security.core.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 主要的过滤处理器
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@Component
public class CoreAuthorizeConfigManager implements AuthorizeConfigManager {

    @Autowired
    private List<AuthorizeConfigProvider> authorizeConfigProviders;

    @Override
    public void config(HttpSecurity httpSecurity) throws Exception {
        for (AuthorizeConfigProvider provider : authorizeConfigProviders) {
            provider.config(httpSecurity);
        }
    }
}
