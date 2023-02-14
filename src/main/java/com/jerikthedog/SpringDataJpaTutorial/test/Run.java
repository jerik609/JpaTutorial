package com.jerikthedog.SpringDataJpaTutorial.test;

import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

public class Run {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

        System.out.println("======== SEPARATOR ========");

        smsService.sendSomeMore("more java");
    }

}
