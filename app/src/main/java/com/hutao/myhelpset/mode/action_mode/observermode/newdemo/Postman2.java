package com.hutao.myhelpset.mode.action_mode.observermode.newdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class Postman2 implements Observable {//快递员
    private List<Observer> personList = new ArrayList<Observer>();//保存收件人（观察者）的信息
    @Override
    public void add(Observer observer) {//添加收件人
        personList.add(observer);
    }

    @Override
    public void delete(Observer observer) {//移除收件人
        personList.remove(observer);
    }

    @Override
    public void notfiy(String message) {//逐一通知收件人（观察者）
        for (Observer observer : personList) {
            observer.update(message);
        }
    }
}