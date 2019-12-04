package config;

import com.mengya.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 验证码bean的配置
 *
 * @author chentongwei@bshf360.com 2018-05-28 16:03
 */
@Configuration
@PropertySource("classpath:security.yml")
@EnableConfigurationProperties(SecurityProperties.class)
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 加密用的
     *
     * 默认注册一个加密bean
     * 这样在UserDetailsService里才能用PasswordEncoder
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
