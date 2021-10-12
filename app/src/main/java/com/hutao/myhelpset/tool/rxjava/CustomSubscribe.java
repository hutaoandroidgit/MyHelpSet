package com.hutao.myhelpset.tool.rxjava;

import com.hutao.helplibrary.log.OsduiLog;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

/**
 * @author: hutao
 * @date: 2021/10/11
 */
public class CustomSubscribe implements BiFunction<Observable, Observer, Observer> {
    @NonNull
    @Override
    public Observer apply(@NonNull Observable observable, @NonNull Observer observer) throws Exception {
        OsduiLog.mtuiHintLog("CustomSubscribe",observable.toString());
        OsduiLog.mtuiHintLog("CustomSubscribe",observer.toString());
        return observer;
    }
}