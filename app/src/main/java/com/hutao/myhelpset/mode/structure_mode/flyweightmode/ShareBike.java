package com.hutao.myhelpset.mode.structure_mode.flyweightmode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class ShareBike implements IBike{//共享单车类
    private int price = 1;//单价
    private int total;//总价
    @Override
    public void billing(int time) {
        total = time * price;
        System.out.println("骑车花费了" + total + "元");
    }
}