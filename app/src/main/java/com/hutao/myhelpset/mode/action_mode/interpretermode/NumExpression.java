package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class NumExpression extends ArithmeticExpression{ //数字表达式，用来解释数字
    private String strNum;

    public NumExpression(String strNum) {
        this.strNum = strNum;
    }
    @Override
    public Integer interpret(Context context) {//解释数字
        return Integer.parseInt(strNum);
    }
}