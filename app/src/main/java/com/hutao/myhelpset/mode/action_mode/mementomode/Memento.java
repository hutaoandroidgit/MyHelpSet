package com.hutao.myhelpset.mode.action_mode.mementomode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Memento {//备忘录类
    public int level;//等级
    public int coin;//金币数量

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
}