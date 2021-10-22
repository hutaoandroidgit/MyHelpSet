package com.hutao.myhelpset.mode.create_mode.abstractfactorymode;

/**
 * 抽象工厂类，电脑工厂类
 * @author: hutao
 * @date: 2021/10/20
 */
public abstract class ComputerFactory {
    public abstract CPU createCPU();
    public abstract Memory createMemory();
    public abstract HD createHD();
}