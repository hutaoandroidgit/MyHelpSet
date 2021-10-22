package com.hutao.myhelpset.mode.create_mode.singelmode;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 反序列化会会破坏单例
 * 重写readResolve 直接返回单例对象
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton7 implements Serializable {

    private Singleton7() {

    }
    private static final Singleton7 singleton = new Singleton7();

    public Singleton7 getInstance(){
        return singleton;
    }

    private Object readResolve() throws ObjectStreamException {//重写readResolve()
        return singleton;//直接返回单例对象
    }
}