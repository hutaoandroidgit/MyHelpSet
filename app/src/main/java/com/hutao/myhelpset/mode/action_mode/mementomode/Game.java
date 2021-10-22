package com.hutao.myhelpset.mode.action_mode.mementomode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Game {
    private int mLevel = 1;  //等级
    private int mCoin = 0;  //金币
    @Override
    public String toString() {
        return "Game{" +
                "mLevel=" + mLevel +
                ", mCoin=" + mCoin +
                '}';
    }
    public void play(){
        System.out.println("升级了");
        mLevel++;
        System.out.println("当前等级为:" + mLevel);
        System.out.println("获得金币:32");
        mCoin += 32;
        System.out.println("当前金币数量为:" + mCoin);
    }
    public void exit(){
        System.out.println("退出游戏");
        System.out.println("退出游戏时的属性 : " + toString());
    }
    public Memento createMemento(){//创建备忘录,即游戏存档
        Memento memento = new Memento();
        memento.setCoin(mCoin);
        memento.setLevel(mLevel);
        return memento;
    }
    public void setMemento(Memento memento){
        this.mCoin = memento.getCoin();
        this.mLevel = memento.getLevel();
        System.out.println("读取存档信息:" + toString());
    }
}