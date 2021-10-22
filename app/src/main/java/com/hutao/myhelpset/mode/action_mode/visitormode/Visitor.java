package com.hutao.myhelpset.mode.action_mode.visitormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public interface Visitor {
    void visitor(Music music);//访问音乐类
    void visitor(Video video);//访问视频类
}
