package com.hutao.myhelpset.mode.action_mode.handlerlinkmode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class SHPostman extends Postman{//上海快递员
    @Override
    public void handlerCourrier(String address) {
        if ("SH".equals(address)){
            System.out.println("订单快递派送到上海");
        }else{
            nextPostman.handlerCourrier(address);
        }
    }
}