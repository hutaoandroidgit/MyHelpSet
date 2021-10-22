package com.hutao.myhelpset.mode.create_mode.singelmode;

/**
 * 单例 懒汉式-线程不安全
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton2 {
    private Singleton2(){

    }
    private static Singleton2 singleton2 = null;

    public Singleton2 getInstance(){
        if (singleton2 == null){
            singleton2 = new Singleton2(); //在第一次调用getInstance()时才实例化，实现懒加载,所以叫懒汉式
        }
        return singleton2;
    }
}