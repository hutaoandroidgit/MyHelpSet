package com.hutao.myhelpset.mode.action_mode.handlerlinkmode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class GZPostman extends Postman{//广州快递员
    @Override
    public void handlerCourrier(String address) {
        if ("GZ".equals(address)){
            System.out.println("订单快递派送到广州");
        }else{
            nextPostman.handlerCourrier(address);
        }
    }
}