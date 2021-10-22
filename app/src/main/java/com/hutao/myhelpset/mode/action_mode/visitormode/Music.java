package com.hutao.myhelpset.mode.action_mode.visitormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Music extends Web{//音乐类，继承自Web类

    public Music(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {//接受访问者的访问
        visitor.visitor(this);
    }

    @Override
    public void download() {//实现父类中的公共方法
        System.out.println("下载音乐~~");
    }

    public void playMusic(){//音乐类独有方法
        System.out.println("播放音乐ing");
    }
}