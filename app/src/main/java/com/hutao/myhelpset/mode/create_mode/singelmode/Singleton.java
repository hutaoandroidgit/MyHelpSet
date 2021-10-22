package com.hutao.myhelpset.mode.create_mode.singelmode;

/**
 * 单例类 - 饿汉式
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton {

    //构造方法为private,防止外部代码直接通过new来构造多个对象
    private Singleton() {

    }
    //在类初始化时，已经自行实例化,所以是线程安全的。
    private static final Singleton singleton = new Singleton();

    //通过getInstance()方法获取实例对象
    public Singleton getInstance(){
        return singleton;
    }
}