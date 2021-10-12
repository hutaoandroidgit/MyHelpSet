package com.hutao.myhelpset.tool.rxjava;

import com.hutao.helplibrary.log.OsduiLog;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author: hutao
 * @date: 2021/10/12
 */
public class SubjectObserver<T extends String> implements Observer<String> {
    public String name = "";

    public SubjectObserver(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        OsduiLog.mtuiHintLog("SubjectObserver",name+"########SubjectObserver onSubscribe########");
    }

    @Override
    public void onNext(@NonNull String s) {
        OsduiLog.mtuiHintLog("SubjectObserver",name+"########SubjectObserver onNext########"+s);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        OsduiLog.mtuiHintLog("SubjectObserver","########SubjectObserver onError########"+e.getStackTrace());
    }

    @Override
    public void onComplete() {
        OsduiLog.mtuiHintLog("SubjectObserver",name+"########SubjectObserver onComplete########");
    }
}