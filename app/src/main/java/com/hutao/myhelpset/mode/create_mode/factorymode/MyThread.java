package com.hutao.myhelpset.mode.create_mode.factorymode;

import androidx.annotation.Nullable;

/**
 * 自定义线程产品类MyThread
 * @author: hutao
 * @date: 2021/10/20
 */
public class MyThread extends Thread implements Runnable{
    public MyThread(@Nullable Runnable target,String name) {
        super(target,name);
    }

    @Override
    public void run() {
        System.out.println("Tread name:"+super.getName());
        super.run();
    }
}