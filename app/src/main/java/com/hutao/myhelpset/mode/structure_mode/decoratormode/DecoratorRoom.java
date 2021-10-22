package com.hutao.myhelpset.mode.structure_mode.decoratormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class DecoratorRoom extends Room{//继承Room，拥有父类相同的方法
    private Room room;//持有被装饰者的引用，这里是需要装修的房间

    public DecoratorRoom(Room room) {
        this.room = room;
    }

    @Override
    public void fitment() {
        room.fitment();//调用被装饰者的方法
    }
}