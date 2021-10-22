package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class ArithmeticExpression {//抽象算术表达式
    public abstract Object interpret(Context context);//抽象解释方法
}