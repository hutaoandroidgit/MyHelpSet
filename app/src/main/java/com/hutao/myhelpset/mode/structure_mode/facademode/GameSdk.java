package com.hutao.myhelpset.mode.structure_mode.facademode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class GameSdk {
    public void login() {//登录接口
        //调用登录子系统的接口
        LoginManager loginManager = new LoginManager();
        loginManager.login();
    }

    public void pay(int momey) {//支付接口
        //调用支付子系统的接口
        PayManager payManager = new PayManager();
        payManager.pay(momey);
    }
}