package com.hutao.myhelpset.tool.rxjava;

import com.hutao.helplibrary.log.OsduiLog;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * @author: hutao
 * @date: 2021/10/11
 */
public class CustomAssembly implements Function<Observable, Observable> {
    @Override
    public Observable apply(@NonNull Observable observable) throws Exception {
        OsduiLog.mtuiHintLog("CustomAssembly",observable.toString());
        return observable;
    }
}