package com.jerikthedog.SpringDataJpaTutorial.objectProxyExample;

public class Run {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

        System.out.println("======== SEPARATOR ========");

        smsService.sendSomeMore("more java");
    }

}
