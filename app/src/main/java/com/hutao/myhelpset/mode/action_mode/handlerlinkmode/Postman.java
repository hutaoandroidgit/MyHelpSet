package com.hutao.myhelpset.mode.action_mode.handlerlinkmode;

/**
 * 责任链模式
 * @author: hutao
 * @date: 2021/10/20
 */
public abstract class Postman {//快递员抽象类
    public Postman nextPostman;  //下一个快递员
    public abstract void handlerCourrier(String address);//派送地址
}