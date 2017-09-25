package com.hldfxh.smartframework;

import com.hldfxh.smartframework.demo.Hello;
import com.hldfxh.smartframework.demo.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by FXH on 2017/9/25.
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(proxy, args);
        return result;
    }

    private <T> T getProxy(){
        Object proxyInstance = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
        return (T)proxyInstance;
    }
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloImpl());
        Hello helloProxy = dynamicProxy.getProxy();
        helloProxy.say();
    }
}


