package com.hutao.myhelpset.mode.create_mode.abstractfactorymode;

/**
 * 具体工厂类--联想电脑
 * @author: hutao
 * @date: 2021/10/20
 */
public class LenovoComptuer extends ComputerFactory{

    @Override
    public CPU createCPU() {
        return new IntelCPU();
    }

    @Override
    public Memory createMemory() {
        return new SamsunMemory();
    }

    @Override
    public HD createHD() {
        return new SeagatHD();
    }
}