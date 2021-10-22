package com.hutao.myhelpset.mode.action_mode.mediatormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Landlord extends FangPerson {//房东者类，继承Person

    public Landlord(HouseMediator houseMediator) {
        super(houseMediator);
    }

    @Override
    public void send(String msg) {
        System.out.println("房东发布信息：" + msg);
        houseMediator.notice(this,msg);
    }

    @Override
    public void getNotice(String msg) {
        System.out.println("房东收到消息：" + msg);
    }
}