package com.hutao.myhelpset.mode.action_mode.observermode.newdemo;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public interface Observable {//抽象被观察者
    void add(Observer observer);//添加观察者
    void delete(Observer observer);//删除观察者
    void notfiy(String message);//通知观察者
}
