package com.hutao.myhelpset.tool.rxjava.code;

/**
 * 发射器接口
 * @author: hutao
 * @date: 2021/10/19
 */
public interface Emitter<T> {
    void onNext(T t);
    void onError();
}