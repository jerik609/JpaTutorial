package com.jerikthedog.SpringDataJpaTutorial.test;

public class SmsServiceImpl implements SmsService {
    public void send(String message) {
        System.out.println("send message:" + message);
        sendSomeMore(message);
    }

    public void sendSomeMore(String message) {
        System.out.println("sending some more: " + message);
    }

}