package com.hutao.myhelpset.mode.action_mode.visitormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Video extends Web{//视频类，继承自Web类

    public Video(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {//接受访问者的访问
        visitor.visitor(this);
    }

    @Override
    public void download() {//实现父类中的公共方法
        System.out.println("下载视频~~");
    }

    public void playVideo(){//视频类独有方法
        System.out.println("播放视频ing");
    }
}