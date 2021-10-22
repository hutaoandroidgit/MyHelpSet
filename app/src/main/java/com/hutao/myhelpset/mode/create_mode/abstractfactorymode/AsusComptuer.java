package com.hutao.myhelpset.mode.create_mode.abstractfactorymode;

/**
 * 具体工厂类--华硕电脑
 * @author: hutao
 * @date: 2021/10/20
 */
public class AsusComptuer extends ComputerFactory{
    @Override
    public CPU createCPU() {
        return new AmdCPU();
    }

    @Override
    public Memory createMemory() {
        return new KingStonMemory();
    }

    @Override
    public HD createHD() {
        return new WdHD();
    }
}