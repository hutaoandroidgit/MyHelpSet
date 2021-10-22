package com.hutao.myhelpset.mode.action_mode.stragetymode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class Context {
    public ChaseStragety chaseStragety;//定义抽象策略类

    public Context(ChaseStragety chaseStragety) {//构造方法传递具体策略对象过来
        this.chaseStragety = chaseStragety;
    }

    public void chase(){//执行具体策略对象的策略
        chaseStragety.chase();
    }
}