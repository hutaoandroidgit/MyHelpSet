package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class AddExpression extends ArithmeticExpression{//加法表达式，用来解释加法,如a+b
    private ArithmeticExpression left, right;//加号左右两边的内容

    public AddExpression(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public Integer interpret(Context context) {//解释加法表达式的结果，即算出left+right的结果
        return context.get((String) left.interpret(context)) + context.get((String) right.interpret(context));
    }
}