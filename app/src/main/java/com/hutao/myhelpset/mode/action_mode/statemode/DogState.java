package com.hutao.myhelpset.mode.action_mode.statemode;

/**
 * 单身狗状态
 * @author: hutao
 * @date: 2021/10/20
 */
public class DogState implements PersonState{
    @Override
    public void movies() {
        System.out.println("一个人看大片");
    }

    @Override
    public void shooping() {
        //空实现
    }
}