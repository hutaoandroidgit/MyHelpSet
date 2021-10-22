package com.hutao.myhelpset.mode.action_mode.visitormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Idler implements Visitor{//闲人
    private String name;

    public Idler(String name) {
        this.name = name;
    }

    @Override
    public void visitor(Music music) {
        System.out.println(name + "浏览音乐网站：" + music.getName());
        music.playMusic();
    }

    @Override
    public void visitor(Video video) {
        System.out.println(name + "浏览视频网站：" + video.getName());
        video.playVideo();
    }
}