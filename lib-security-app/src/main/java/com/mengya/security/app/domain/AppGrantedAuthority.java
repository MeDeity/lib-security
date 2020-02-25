package com.mengya.security.app.domain;

import org.springframework.security.core.GrantedAuthority;

public class AppGrantedAuthority implements GrantedAuthority {
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
