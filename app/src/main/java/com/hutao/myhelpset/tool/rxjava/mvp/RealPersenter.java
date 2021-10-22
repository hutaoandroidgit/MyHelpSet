package com.hutao.myhelpset.tool.rxjava.mvp;

import com.hutao.myhelpset.tool.rxjava.mvp.presenter.CustomPersenter;
import com.hutao.myhelpset.tool.rxjava.mvp.view.CustomView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 实现P层
 * @author: hutao
 * @date: 2021/10/18
 */
public class RealPersenter extends CustomPersenter {
    @Override
    protected void loadData() {
        //实际loadData位置
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("创建的时候传入ObservableOnSubscribe接口");
                emitter.onNext("订阅了一个观察者");
                emitter.onNext("订阅之后带上发射器接口回调");
                emitter.onNext("发射器发射消息回调到观察者的方法");
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.onLoading("数据加载中...\n");
                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        try {
                            Thread.sleep(1000);
                        }catch (Exception e){

                        }
                        mView.onRefreshData("网络上获取数据："+s +"\n");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mView.onComplete("加载完成... \n");
                    }
                });
    }







    //该实现的RealPersenter 对应管理RealViewActivity的生命周期
    @Override
    protected void onPause() {
        super.onPause();
    }
}