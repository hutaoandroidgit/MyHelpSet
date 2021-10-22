package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.RxActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: hutao
 * @date: 2021/10/18
 */
public class RxLifecycleActivity extends RxActivity {
    private TextView textView;
    private Button button2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initContentComponentValue();
    }

    protected int getLayoutResId() {
        return R.layout.activity_rxlifecycle;
    }

    protected void initContentComponentValue() {
        textView = findViewById(R.id.textView);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                        for (int i = 0; i < 20; i++) {
                            Thread.sleep(200);
                            emitter.onNext("RxLifecycle"+i);
                        }
                    }
                })//绑定到RxActivity 的PAUSE生命周期  会在该生命周期释放
                        //.compose(RxLifecycleActivity.this.bindUntilEvent(ActivityEvent.PAUSE))
                        //模拟网络请求在子线程
                        .subscribeOn(Schedulers.io())
                        //刷新UI 在主线程
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                textView.setText(s);
                            }
                        });
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Tag","onPause");
    }
}