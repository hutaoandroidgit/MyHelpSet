package com.hutao.myhelpset.tool.rxjava.code;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;

/**
 * 手写Rxjava原理代码
 * @author: hutao
 * @date: 2021/10/19
 */
public class CodeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_code;
    }

    @Override
    protected void initContentComponentValue() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("1111");
                emitter.onError();
                emitter.onNext("2222");
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe() {
                OsduiLog.mtuiHintLog(TAG,"########Observer onSubscribe########");
            }

            @Override
            public void onNext(String s) {
                OsduiLog.mtuiHintLog(TAG,"########Observer onNext########"+s);
            }

            @Override
            public void onError() {
                OsduiLog.mtuiHintLog(TAG,"########Observer onError########");
            }

            @Override
            public void onComplete() {
                OsduiLog.mtuiHintLog(TAG,"########Observer onComplete########");
            }
        });
    }

    @Override
    protected void createListeners() {

    }
}