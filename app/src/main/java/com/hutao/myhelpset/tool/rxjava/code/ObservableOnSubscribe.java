package com.hutao.myhelpset.tool.rxjava.code;

/**
 * 被观察者被订阅的时候
 * 实际就是一个成功订阅观察者的回调  回调传回发射器 进去发射器操作
 * @author: hutao
 * @date: 2021/10/19
 */
public interface ObservableOnSubscribe<T>{
    void subscribe(Emitter<T> emitter);
}
