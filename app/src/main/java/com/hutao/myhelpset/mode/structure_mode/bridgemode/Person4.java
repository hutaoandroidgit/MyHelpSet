package com.hutao.myhelpset.mode.structure_mode.bridgemode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class Person4 {
    Clothes clothes;//持有衣服类的引用

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public abstract void dress();//穿衣服
}