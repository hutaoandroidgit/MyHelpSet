package com.hutao.myhelpset.tool.rxjava.mvp.view;

import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpView;

/**
 * 封装V层的抽象层
 * V层只需要声明出需要实现的方法
 * 该包可以写各种对应接口方法 继承MvpView的接口
 * @author: hutao
 * @date: 2021/10/18
 */
public interface CustomView extends MvpView {

    void onLoading(String text);

    void onRefreshData(String text);

    void onError(String text);

    void onComplete(String text);
}

