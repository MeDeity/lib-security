package com.mengya.security.app.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 前后端分离的情况下,
 * 保存到Redis数据库的权限信息转Authentication需要用到该实体类作为桥接
 * create by fengwenhua at 2020-1-11 17:22:20
 */
public class AppAuthentication<T extends GrantedAuthority> implements Authentication {

    private boolean authenticated;

    private Object principal;

    private Object details;

    private Object credentials;

    private Collection<T> authorities;

    private String name;


    @Override
    public Collection<T> getAuthorities() {
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

    public void setPrincipal(Object principal) {
        this.principal = principal;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }

    public void setAuthorities(Collection<T> authorities) {
        this.authorities = authorities;
    }

    public void setName(String name) {
        this.name = name;
    }
}
