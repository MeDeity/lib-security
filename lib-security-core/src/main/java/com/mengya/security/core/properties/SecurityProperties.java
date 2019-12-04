package com.mengya.security.core.properties;

import com.mengya.security.core.properties.authentication.AuthenticationProperties;
import com.mengya.security.core.properties.authorize.AuthorizeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@ConfigurationProperties("core.security")
public class SecurityProperties {
    /** 授权模块配置 */
    private AuthorizeProperties authorize;
    /** 认证模块配置 */
    private AuthenticationProperties authentication;

    public AuthorizeProperties getAuthorize() {
        return authorize;
    }

    public void setAuthorize(AuthorizeProperties authorize) {
        this.authorize = authorize;
    }

    public AuthenticationProperties getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationProperties authentication) {
        this.authentication = authentication;
    }
}
