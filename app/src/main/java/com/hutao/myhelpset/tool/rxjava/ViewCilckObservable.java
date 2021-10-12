package com.hutao.myhelpset.tool.rxjava;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * @author: hutao
 * @date: 2021/10/8
 */
public class ViewCilckObservable extends Observable<Object> {
    private View view;

    public ViewCilckObservable(View view) {
        this.view = view;
    }


    @Override
    protected void subscribeActual(Observer<? super Object> observer) {
        if (view != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    observer.onNext(v);
                }
            });
        }
    }
}