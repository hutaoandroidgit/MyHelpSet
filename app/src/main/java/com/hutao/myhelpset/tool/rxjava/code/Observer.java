package com.hutao.myhelpset.tool.rxjava.code;

/**
 * 观察者
 * @author: hutao
 * @date: 2021/10/19
 */
public interface Observer<T> {
    void onSubscribe();
    void onNext(T t);
    void onError();
    void onComplete();
}
