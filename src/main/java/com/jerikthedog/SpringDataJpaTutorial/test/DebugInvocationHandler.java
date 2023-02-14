package com.jerikthedog.SpringDataJpaTutorial.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DebugInvocationHandler implements InvocationHandler {
    /**
     * real object in the proxy class
     */
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        //before invoking the method, we can add our own actions
        System.out.println("-- INVOCATION_HANDLER: before method " + method.getName());
        Object result = method.invoke(target, args);
        //After calling the method, we can also add our own actions
        System.out.println("-- INVOCATION_HANDLER: after method " + method.getName());
        return result;
    }
}