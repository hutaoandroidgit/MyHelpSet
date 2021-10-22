package com.hutao.myhelpset.mode.structure_mode.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class DynamicProxy implements InvocationHandler {//实现InvocationHandler接口
    private Object obj;//被代理的对象

    public DynamicProxy(Object obj) {
        this.obj = obj;
    }
    //重写invoke()方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("海外动态代理调用方法： "+method.getName());
        Object result = method.invoke(obj,args);
        return result;
    }
}