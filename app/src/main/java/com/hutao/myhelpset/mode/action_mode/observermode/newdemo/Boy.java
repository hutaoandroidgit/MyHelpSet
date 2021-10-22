package com.hutao.myhelpset.mode.action_mode.observermode.newdemo;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class Boy implements Observer{
    private String name;

    public Boy(String name) {//男孩的具体反应
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + ",收到了信息:" + message+"屁颠颠的去取快递.");
    }
}