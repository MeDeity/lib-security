package com.mengya.security.core.constant;

/**
 * 核心包的配置
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public interface CoreConstants {
    /**
     * 当访问需要身份认证的接口时，需要跳转到的URL
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
}
