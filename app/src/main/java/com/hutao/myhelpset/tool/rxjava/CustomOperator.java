package com.hutao.myhelpset.tool.rxjava;

import java.util.List;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author: hutao
 * @date: 2021/10/11
 */
public class CustomOperator implements ObservableOperator<String, List<String>> {
    @NonNull
    @Override
    public Observer<? super List<String>> apply(@NonNull Observer<? super String> observer) throws Exception {
        return new Observer<List<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                observer.onSubscribe(d);
            }

            @Override
            public void onNext(@NonNull List<String> strings) {
                observer.onNext(strings.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                observer.onError(e);
            }

            @Override
            public void onComplete() {
                observer.onComplete();
            }
        };
    }
}