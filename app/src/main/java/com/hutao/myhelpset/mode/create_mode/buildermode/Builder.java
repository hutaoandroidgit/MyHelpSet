package com.hutao.myhelpset.mode.create_mode.buildermode;

/**
 * 定义抽象建造者（Builder）：组装电脑的过程
 * @author: hutao
 * @date: 2021/10/19
 */
public abstract class Builder {
    public abstract void buildCPU(String mCPU); //组装CPU
    public abstract void buildMemory(String mMemort); //组装Memory
    public abstract void buildHD(String mHD); //组装HD
    public abstract Computer create(); //返回组装后的电脑实体
}