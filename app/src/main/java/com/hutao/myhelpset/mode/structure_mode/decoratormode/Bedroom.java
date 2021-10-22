package com.hutao.myhelpset.mode.structure_mode.decoratormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Bedroom extends DecoratorRoom{//卧室类，继承自RoomDecorator
    public Bedroom(Room room) {
        super(room);
    }

    @Override
    public void fitment() {
        super.fitment();
        addBedding();
    }

    private void addBedding() {
        System.out.println("装修成卧室：添加卧具");
    }
}