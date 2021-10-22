package com.hutao.myhelpset.mode.create_mode.singelmode;

/**
 * 单例 双重检测锁定
 * @author: hutao
 * @date: 2021/10/19
 */
public class Singleton4 {
    private Singleton4(){

    }
    private volatile static Singleton4 singleton4 = null; //volatile 能够防止代码的重排序，保证得到的对象是初始化过

    public Singleton4 getInstance(){
        if (singleton4 != null){  //第一次检查，避免不必要的同步
            synchronized (Singleton4.class){ //同步
                if (singleton4 != null){ //第二次检查，为null时才创建实例
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}