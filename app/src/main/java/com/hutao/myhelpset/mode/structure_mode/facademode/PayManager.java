package com.hutao.myhelpset.mode.structure_mode.facademode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class PayManager {//支付系统
    public void pay(int momey) {
        System.out.println("生成订单信息");
        System.out.println("选择支付方式");
        System.out.println("支付成功：" + momey + "元");
    }
}