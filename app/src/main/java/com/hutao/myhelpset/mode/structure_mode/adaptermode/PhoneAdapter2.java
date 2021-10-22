package com.hutao.myhelpset.mode.structure_mode.adaptermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class PhoneAdapter2 extends Electric implements Adapter{//通过继承源目标类的方式，不持有源目标对象
    @Override
    public int convert_5v() {
        System.out.println("适配器开始工作：");
        System.out.println("输入电压：" + output_220v());
        System.out.println("输出电压：" + 5);
        return 5;
    }
}