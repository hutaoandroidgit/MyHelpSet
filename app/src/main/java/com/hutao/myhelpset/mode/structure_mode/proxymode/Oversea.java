package com.hutao.myhelpset.mode.structure_mode.proxymode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Oversea implements People{
    People people;//持有People类的引用

    public Oversea(People people) {
        this.people = people;
    }

    @Override
    public void buy() {
        System.out.println("我是海外代购：");
        people.buy();//调用了被代理者的buy()方法,
    }
}