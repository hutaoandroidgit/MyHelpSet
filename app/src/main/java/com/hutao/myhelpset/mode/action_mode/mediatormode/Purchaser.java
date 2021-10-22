package com.hutao.myhelpset.mode.action_mode.mediatormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Purchaser extends FangPerson {//买房者类，继承Person


    public Purchaser(HouseMediator houseMediator) {
        super(houseMediator);
    }

    @Override
    public void send(String msg) {
        System.out.println("买房者发布信息：" + msg);
        houseMediator.notice(this,msg);
    }

    @Override
    public void getNotice(String msg) {
        System.out.println("买房者收到消息：" + msg);
    }
}