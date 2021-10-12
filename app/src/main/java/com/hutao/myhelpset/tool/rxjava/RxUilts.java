package com.hutao.myhelpset.tool.rxjava;

import android.view.View;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: hutao
 * @date: 2021/10/8
 */
public class RxUilts {
    public static Observable<Object> click(final View view, long seconds){
        return new ViewCilckObservable(view)
                .throttleFirst(seconds, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (view != null){
                            view.setOnClickListener(null);
                        }
                    }
                });
    }
}