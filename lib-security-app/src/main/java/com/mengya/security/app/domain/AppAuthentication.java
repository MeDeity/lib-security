package com.mengya.security.app.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 前后端分离的情况下,
 * 保存到Redis数据库的权限信息转Authentication需要用到该实体类作为桥接
 * create by fengwenhua at 2020-1-11 17:22:20
 */
public class AppAuthentication implements Authentication {

    private boolean authenticated;

    private Object principal;

    private Object details;

    private Object credentials;

    private Collection<? extends GrantedAuthority> authorities;

    private String name;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getDetails() {
        return details;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }

    @Override
    public String getName() {
        return name;
    }
}
