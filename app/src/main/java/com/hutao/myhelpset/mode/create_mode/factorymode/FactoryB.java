package com.hutao.myhelpset.mode.create_mode.factorymode;

/**
 * 具体工厂类B
 * @author: hutao
 * @date: 2021/10/20
 */
public class FactoryB extends Factory{
    @Override
    public Product create() {
        return new ProductB();//创建ProductB
    }
}