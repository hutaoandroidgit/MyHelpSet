package com.hutao.myhelpset.mode.create_mode.buildermode;

import android.os.Build;

/**
 *  创建具体的建造者（ConcreteBuilder）:装机人员
 * @author: hutao
 * @date: 2021/10/19
 */
public class ConcreteBuilder extends Builder {
    private Computer computer = new Computer();
    @Override
    public void buildCPU(String mCPU) {
        computer.setmCPU(mCPU);
    }

    @Override
    public void buildMemory(String mMemort) {
        computer.setmMemory(mMemort);
    }

    @Override
    public void buildHD(String mHD) {
        computer.setmHD(mHD);
    }

    @Override
    public Computer create() {
        return computer;
    }
}