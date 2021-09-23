package com.hutao.myhelpset.mode.observer;

import com.hutao.helplibrary.log.OsduiLog;

/**
 * 牛奶顾客（观察者）
 * @author: hutao
 * @date: 2021/9/16
 */
public class MilkConsumer implements Observer {
    private String mName;
    public MilkConsumer(String mName) {
        this.mName = mName;
    }

    @Override
    public void onNotify() {
        OsduiLog.mtuiHintLog(this,"收到牛奶");
    }
}