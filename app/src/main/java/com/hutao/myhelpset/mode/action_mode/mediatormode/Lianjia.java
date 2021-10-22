package com.hutao.myhelpset.mode.action_mode.mediatormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Lianjia implements HouseMediator{//链家，实现HouseMediator
    Purchaser purchaser;
    Landlord landlord;

    public void setPurchaser(Purchaser purchaser) {//设置买房者
        this.purchaser = purchaser;
    }

    public void setLandlord(Landlord landlord) {//设置房东
        this.landlord = landlord;
    }

    @Override
    public void notice(FangPerson person, String msg) {//发送通知
        System.out.println("中介收到信息，并转发给相应的目标人群");
        if (person == purchaser){
            landlord.getNotice(msg);
        }else if (person == landlord){
            purchaser.getNotice(msg);
        }
    }
}