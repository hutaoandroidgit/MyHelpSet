package com.hutao.myhelpset.mode.action_mode.handlerlinkmode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class BJPostman extends Postman{ //北京快递员
    @Override
    public void handlerCourrier(String address) {
        if ("BJ".equals(address)){//北京地区的则派送
            System.out.println("订单快递派送到北京");
        }else{//否则交给下一个快递员去处理
            nextPostman.handlerCourrier(address);
        }
    }
}