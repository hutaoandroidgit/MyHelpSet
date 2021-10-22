package com.hutao.myhelpset.tool.rxjava.mvp.presenter;

import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpPresenter;
import com.hutao.myhelpset.tool.rxjava.mvp.view.CustomView;

/**
 * 封装P层 的抽象类
 * P层只需要声明出需要处理的方法
 * @author: hutao
 * @date: 2021/10/18
 */
public abstract class CustomPersenter extends MvpPresenter<CustomView> {
    public CustomPersenter() {
        super();
    }

    protected abstract void loadData();
}