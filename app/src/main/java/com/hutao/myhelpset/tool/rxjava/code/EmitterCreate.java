package com.hutao.myhelpset.tool.rxjava.code;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/**
 * 发射器实例 传入观察者 回调观察者方法
 * @author: hutao
 * @date: 2021/10/19
 */
public class EmitterCreate<T> extends AtomicReference<Disposable> implements Emitter<T>,Disposable{
    private Observer<T> observer;

    public EmitterCreate(Observer<T> observer) {
        this.observer = observer;
    }
    @Override
    public void onNext(T t) {
        if (!isDisposed()){
            observer.onNext(t);
        }
    }
    @Override
    public void onError() {
        if (!isDisposed()){
            try {
                observer.onError();
            }finally {
                dispose();
            }
        }

    }
    @Override
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }
}