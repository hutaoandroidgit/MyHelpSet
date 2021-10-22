package com.hutao.myhelpset.mode.create_mode.abstractfactorymode;

/**
 * 具体实现产品类- Intel CPU
 * @author: hutao
 * @date: 2021/10/20
 */
public class IntelCPU extends CPU{
    @Override
    public void showCPU() {
        System.out.println("Intel CPU");
    }
}