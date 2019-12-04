package com.mengya.security.core;


import com.mengya.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
@Configuration
@PropertySource("classpath:security.yml")
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
