package com.hutao.myhelpset.mode.action_mode.iteratormode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public interface Aggragate {
    int size();//容器大小
    String get(int index);//获取获取中指定位置的号码
    void add(String tel); //添加号码到容器中
    void remove(String tel);//从容器中移除号码
    Iterator iteretor();//返回容器的迭代器
}
