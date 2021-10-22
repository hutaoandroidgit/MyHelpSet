package com.hutao.myhelpset.mode.structure_mode.decoratormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Kitchen extends DecoratorRoom{//厨房类，继承自RoomDecorator
    public Kitchen(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        addKitchenware();
    }

    private void addKitchenware() {
        System.out.println("装修成厨房：添加厨具");
    }
}