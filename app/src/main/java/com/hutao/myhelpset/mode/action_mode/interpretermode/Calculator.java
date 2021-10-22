package com.hutao.myhelpset.mode.action_mode.interpretermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Calculator {//计算器类
    Context context = new Context();
    private ArithmeticExpression mExpression;

    public void read(String expression){//读取表达式
        String[] split = expression.split(" ");//表达式以空格隔开，方便拆分
        switch (split[1]) {//根据不同符号去执行具体的解析操作
            case "=":
                new EqualExpression(new VarExpression(split[0]), new NumExpression(split[2])).interpret(context);
                break;
            case "+":
                mExpression = new AddExpression(new VarExpression(split[0]), new VarExpression(split[2]));
                break;
            case "-":
                mExpression = new SubExpression(new VarExpression(split[0]), new VarExpression(split[2]));
                break;
        }
    }

    public int calculate() {//计算结果
        return (int) mExpression.interpret(context);
    }
}