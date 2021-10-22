package com.hutao.myhelpset.mode.action_mode.templatemode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class PostToA extends PostmanTemplate{//派送给A先生
    @Override
    protected void call() {//联系收货，实现父类的抽象方法
        System.out.println("联系A先生并送到门口");
    }
}