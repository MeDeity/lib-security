package com.mengya.security.core.properties.authentication;

import com.mengya.security.core.enums.LoginTypeEnum;

/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public class AuthenticationProperties {
    /**
     * 登录方式，跳转页面/JSON
     */
    private LoginTypeEnum loginType = LoginTypeEnum.JSON;

    /**
     * 若为跳转页面的形式，则登录失败后跳转到的页面，替代SpringBoot提供的默认页面
     */
    private String loginErrorPage;

    /**
     * 若为跳转页面的形式，则登录成功后跳转到的页面，默认为上一次请求的url
     */
    private String loginSuccessPage;

    public LoginTypeEnum getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginTypeEnum loginType) {
        this.loginType = loginType;
    }

    public String getLoginErrorPage() {
        return loginErrorPage;
    }

    public void setLoginErrorPage(String loginErrorPage) {
        this.loginErrorPage = loginErrorPage;
    }

    public String getLoginSuccessPage() {
        return loginSuccessPage;
    }

    public void setLoginSuccessPage(String loginSuccessPage) {
        this.loginSuccessPage = loginSuccessPage;
    }
}
