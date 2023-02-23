package com.jerikthedog.SpringDataJpaTutorial.objectProxyExample;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // class load of the target class
                target.getClass().getInterfaces(), // interfaces to be implemented by the proxy, multiple interfaces can be specified
                new DebugInvocationHandler(target) // custom InvocationHandler corresponding to the proxy object
        );
    }
}