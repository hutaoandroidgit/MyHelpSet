package com.hutao.myhelpset.mode.create_mode.abstractfactorymode;

/**
 * 具体产品类-- AMD CPU
 * @author: hutao
 * @date: 2021/10/20
 */
public class AmdCPU extends CPU{

    @Override
    public void showCPU() {
        System.out.println("Amd CPU");
    }
}