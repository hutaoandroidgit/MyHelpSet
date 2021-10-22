package com.hutao.myhelpset.mode.create_mode.singelmode;

/**
 * 单例 懒汉式-线程安全
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton3 {
    private Singleton3(){

    }
    private static Singleton3 singleton3 = null;

    public synchronized Singleton3 getInstance(){ //加上synchronized同步
        if (singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}