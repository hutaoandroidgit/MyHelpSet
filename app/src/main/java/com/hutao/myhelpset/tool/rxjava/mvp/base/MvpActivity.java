package com.hutao.myhelpset.tool.rxjava.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpPresenter;
import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpView;

/**
 * 封装Activity
 * Activity实现MvpView接口
 * Activity持有P层的实例，且回调P层的生命周期，对外提供创建P层的抽象方法
 * @author: hutao
 * @date: 2021/10/18
 */
public abstract class MvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView {
    protected P presenter;

    /**
     * @description 提供创建Presenter方法给子activity继承重写
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/18 14:25
     */
    protected abstract P creatPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = creatPresenter();  //创建P层实例 由各个子类activity重写
        if (presenter != null){
            presenter.attach(this);   //子类创建各自P层实例 绑定自己的实现接口MvpView
            presenter.onCreate(savedInstanceState);  //调用当前生命周期
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }
}
