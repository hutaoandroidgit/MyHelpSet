package com.hutao.myhelpset.mode.action_mode.templatemode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class PostToB extends PostmanTemplate{//派送给B先生
    @Override
    protected void call() {//联系收货，实现父类的抽象方法
        System.out.println("联系B先生并送到门口");
    }

    @Override
    protected boolean isSign() {//是否签收,覆盖父类的钩子方法，控制流程的走向
        return false;
    }

    @Override
    protected void refuse() {//拒签，覆盖父类的钩子方法
        System.out.println("拒绝签收：商品不符");
    }
}