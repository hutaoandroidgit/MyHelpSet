package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class EqualExpression extends ArithmeticExpression{//等号表达式，用来解释变量赋值，如a=1024
    private ArithmeticExpression left, right;//等号左右两边的内容

    public EqualExpression(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public Object interpret(Context context) {//解释等号表达式的结果，并将结果保存到context，变量名为key,值为value
        context.put((String) left.interpret(context), (int) right.interpret(context));
        return null;
    }
}