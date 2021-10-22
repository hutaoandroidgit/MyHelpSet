package com.hutao.myhelpset.mode.create_mode.factorymode;

/**
 * 具体工厂类A
 * @author: hutao
 * @date: 2021/10/20
 */
public class FactoryA extends Factory{
    @Override
    public Product create() {
        return new ProductA();//创建ProductA
    }
}