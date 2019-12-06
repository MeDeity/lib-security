package com.mengya.security.browser;

import com.mengya.security.browser.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:security.properties")
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityBrowserConfig {
}
