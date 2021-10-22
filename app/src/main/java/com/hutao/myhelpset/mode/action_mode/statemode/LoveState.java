package com.hutao.myhelpset.mode.action_mode.statemode;

/**
 * 恋爱状态
 * @author: hutao
 * @date: 2021/10/20
 */
public class LoveState implements PersonState {
    @Override
    public void movies() {
        System.out.println("一起电影院看电影");
    }

    @Override
    public void shooping() {
        System.out.println("陪妹子逛街");
    }
}