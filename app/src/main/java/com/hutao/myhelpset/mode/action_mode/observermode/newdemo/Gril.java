package com.hutao.myhelpset.mode.action_mode.observermode.newdemo;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class Gril implements Observer{
    private String name;

    public Gril(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {//女孩的具体反应
        System.out.println(name + ",收到了信息:" + message+"让男朋友去取快递~");
    }
}