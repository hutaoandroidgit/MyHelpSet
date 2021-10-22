package com.hutao.myhelpset.mode.action_mode.visitormode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class Web {
    public String name;

    public Web(String name) {
        this.name = name;
    }
    //定义一个抽象的受访问方法
    public abstract void accept(Visitor visitor);

    //下载资源
    public abstract void download();

    public String getName() {
        return name;
    }
}