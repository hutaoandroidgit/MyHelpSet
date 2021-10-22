package com.hutao.myhelpset.tool.rxjava.mvp.base;

import android.os.Bundle;
import android.util.Log;

import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpView;

/**
 * P层:P层固定需要传入V层接口的泛型类
 * P层持有V层的实例，且带有一套P层自己的生命周期，具体是通过Activity生命周期进行回调的
 * @author: hutao
 * @date: 2021/10/18
 */
public abstract class MvpPresenter<T extends MvpView> {
    public static final String TAG = "MvpPresenter";

    public T mView;
    /**
     * @description 提供attach依附方法 传入V层
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/18 14:19
     */
    public void attach(T view){
        this.mView = view;
    }

    /**
     * 对应 activity/fragment onCreate
     */
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
    }

    /**
     * 对应 activity/fragment onStart
     */
    protected void onStart() {
        Log.i(TAG, "onStart");
    }

    /**
     * 对应 activity/fragment onResume
     */
    protected void onResume() {
        Log.i(TAG, "onResume");
    }

    /**
     * 对应 activity/fragment onPause
     */
    protected void onPause() {
        Log.i(TAG, "onPause");
    }

    /**
     * 对应 activity/fragment onStop
     */
    protected void onStop() {
        Log.i(TAG, "onStop");
    }

    /**
     * 对应 activity/fragment onDestroy
     */
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");
        if (mView != null) {
            mView = null;
        }
    }
}

