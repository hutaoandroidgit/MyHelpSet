package com.hutao.myhelpset.mode.observer;

import java.util.ArrayList;

/**
 * 牛奶店 （被观察者）
 * @author: hutao
 * @date: 2021/9/16
 */
public class MilkFactory implements Observable {
    ArrayList<Observer> mObservers;
    public MilkFactory() {
        mObservers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer mObserver) {
        mObservers.add(mObserver);
    }

    @Override
    public void cancel(Observer mObserver) {
        mObservers.remove(mObserver);
    }

    @Override
    public void onNext() {
        for (Observer item:mObservers) {
            //给所有订奶着发放牛奶
            item.onNotify();
        }
    }
}
