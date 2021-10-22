package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class VarExpression extends ArithmeticExpression{//变量表达式，用来解释变量
    private String var;

    public VarExpression(String var) {
        this.var = var;
    }

    @Override
    public String interpret(Context context) {//解释变量
        return var;
    }
}