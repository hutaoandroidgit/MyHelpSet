package com.hutao.myhelpset.mode.observer;

/**
 * 被观察者接口
 * @author: hutao
 * @date: 2021/9/16
 */
public interface Observable {
    /**
     * @description 订阅方法 被观察者提供给观察者的订阅方法
     * @param mObserver 订阅者
     * @return 
     * @author hutao
     * @time 2021/9/16 10:20
     */
    void subscribe(Observer mObserver);
    /**
     * @description 取消订阅方法
     * @param mObserver 订阅者
     * @return
     * @author hutao
     * @time 2021/9/16 10:27
     */
    void cancel(Observer mObserver);
    /**
     * @description 发布方法 被观察者发布
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/16 10:27
     */
    void onNext();
}
