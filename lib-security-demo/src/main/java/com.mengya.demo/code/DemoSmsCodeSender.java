package com.mengya.demo.code;



import com.mengya.security.validate.code.sms.SmsCodeSender;
import org.springframework.stereotype.Component;


/**
 * 演示了如何自定义发送器
 * @author chentongwei@bshf360.com 2018-03-28 12:46
 */

//@Component
public class DemoSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("自定义发送手机号" + mobile + "code:" + code);
    }
}

