package com.mengya.security.core.authentication;

import com.alibaba.fastjson.JSON;
import com.mengya.security.core.enums.LoginTypeEnum;
import com.mengya.security.core.properties.SecurityProperties;
import com.mengya.security.core.response.ResponseEntity;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author chentongwei@bshf360.com 2018-03-26 11:14
 */
public class CoreAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("验证成功！");
        if (ObjectUtils.equals(securityProperties.getAuthentication().getLoginType(), LoginTypeEnum.JSON)) {
            ResponseEntity result = new ResponseEntity(
                    HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase()
            ).data(authentication);

            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(result));
        } else {
            // 存到session里，方便取值。
            request.getSession().setAttribute("authentication", authentication);
            logger.info("session.authentication:【{}】", JSON.toJSONString(request.getSession().getAttribute("authentication")));
            // 支持跳转到自定义页面
            if (StringUtils.isNotBlank(securityProperties.getAuthentication().getLoginSuccessPage())) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getAuthentication().getLoginSuccessPage());
            } else {
                // 会帮我们跳转到上一次请求的页面上
                super.onAuthenticationSuccess(request, response, authentication);
            }
        }
    }
}
