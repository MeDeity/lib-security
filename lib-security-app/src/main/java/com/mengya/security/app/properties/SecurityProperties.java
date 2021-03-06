package com.mengya.security.app.properties;

import com.mengya.security.app.properties.jwt.JwtProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * APP模块的统一配置
 *
 * @author chentongwei@bshf360.com 2018-06-07 19:51
 */
@ConfigurationProperties(prefix = "core.security")
public class SecurityProperties {

    private JwtProperties jwt = new JwtProperties();

    public JwtProperties getJwt() {
        return jwt;
    }

    public void setJwt(JwtProperties jwt) {
        this.jwt = jwt;
    }

}
