package com.hutao.myhelpset.mode.create_mode.factorymode;

import java.util.concurrent.ThreadFactory;

/**
 * 自定义线程工厂MyFactory
 * @author: hutao
 * @date: 2021/10/20
 */
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new MyThread(r,"this name is MyThread");
    }
}