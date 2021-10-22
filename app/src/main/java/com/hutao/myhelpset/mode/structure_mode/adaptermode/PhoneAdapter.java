package com.hutao.myhelpset.mode.structure_mode.adaptermode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class PhoneAdapter implements Adapter{
    private Electric electric;

    public PhoneAdapter(Electric electric) {
        this.electric = electric;
    }

    @Override
    public int convert_5v() {
        System.out.println("适配器开始工作：");
        System.out.println("输入电压：" + electric.output_220v());
        System.out.println("输出电压：" + 5);
        return 5;
    }
}