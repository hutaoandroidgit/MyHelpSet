package com.hutao.myhelpset.tool.rxjava;

import com.hutao.helplibrary.log.OsduiLog;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @author: hutao
 * @date: 2021/10/11
 */
public class CustomTransformer implements ObservableTransformer<Integer,String> {
    @NonNull
    @Override
    public ObservableSource<String> apply(@NonNull Observable<Integer> upstream) {
        return upstream.take(2).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "序号"+integer+"发射成功";
            }
        }).doOnNext(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                OsduiLog.mtuiHintLog("TAG","准备发射");
            }
        });
    }
}