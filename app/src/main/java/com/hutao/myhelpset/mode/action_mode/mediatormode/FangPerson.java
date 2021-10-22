package com.hutao.myhelpset.mode.action_mode.mediatormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class FangPerson {//人物类
    protected HouseMediator houseMediator;

    public FangPerson(HouseMediator houseMediator) {
        this.houseMediator = houseMediator;//获取中介
    }

    public abstract void send(String msg);//发布信息

    public abstract void getNotice(String msg);//接受信息

}