package com.hutao.myhelpset.tool.rxjava.code;

/**
 * 被观察者
 * @author: hutao
 * @date: 2021/10/19
 */
public abstract class Observable<T> {
    //提供静态create方法创建子类ObservableCreate
    public static <T> ObservableCreate create(ObservableOnSubscribe<T> observableOnSubscribe){
        return new ObservableCreate<T>(observableOnSubscribe);
    }
    //实际的订阅方法 传递观察者
    public void subscribe(Observer<T> observer){
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);
}