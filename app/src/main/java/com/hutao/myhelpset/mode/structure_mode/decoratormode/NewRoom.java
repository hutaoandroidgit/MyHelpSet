package com.hutao.myhelpset.mode.structure_mode.decoratormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class NewRoom extends Room{//继承Room
    @Override
    public void fitment() {
        System.out.println("这是一间新房：装上电");
    }
}