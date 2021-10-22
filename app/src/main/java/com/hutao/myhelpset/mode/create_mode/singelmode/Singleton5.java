package com.hutao.myhelpset.mode.create_mode.singelmode;

/**
 * 单例 静态内部类
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton5 {
    private Singleton5(){

    }
    public Singleton5 getInstance(){
        //第一次调用getInstance方法时才加载SingletonHolder并初始化sInstance
        return SingletonHandler.singleton5;
    }
    //静态内部类
    private static class SingletonHandler{
        private static final Singleton5 singleton5 = new Singleton5();
    }
}