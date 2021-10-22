package com.hutao.myhelpset.tool.rxjava.code;

/**
 * @author: hutao
 * @date: 2021/10/19
 */
public class ObservableCreate<T> extends Observable{

    private ObservableOnSubscribe source;

    public ObservableCreate(ObservableOnSubscribe source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer observer) {
        //固定的三步曲分析法

        //创建发射器
        EmitterCreate<T> emitterCreate = new EmitterCreate<>(observer);

        //回调observer观察者的onSubscribe 表示发射器准备好 观察者被订阅
        observer.onSubscribe();

        //回调observable 被观察者subscribe
        //表示发射器准备好 观察者已被订阅 被观察者可以通过发射器Emitter发射数据
        source.subscribe(emitterCreate);
    }
}