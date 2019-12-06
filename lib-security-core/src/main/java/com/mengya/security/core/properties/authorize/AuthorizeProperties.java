package com.mengya.security.core.properties.authorize;

import org.springframework.stereotype.Component;

/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@Component
public class AuthorizeProperties {
    /** 无需权限即可访问的url */
    private String permitUrls;

    /** 访问无权限的接口时，跳转到哪个页面 */
    private String unAuthorizePage;

    public String getPermitUrls() {
        return permitUrls;
    }

    public void setPermitUrls(String permitUrls) {
        this.permitUrls = permitUrls;
    }

    public String getUnAuthorizePage() {
        return unAuthorizePage;
    }

    public void setUnAuthorizePage(String unAuthorizePage) {
        this.unAuthorizePage = unAuthorizePage;
    }
}
