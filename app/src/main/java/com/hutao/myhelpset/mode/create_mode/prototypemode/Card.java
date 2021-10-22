package com.hutao.myhelpset.mode.create_mode.prototypemode;

import androidx.annotation.NonNull;

/**
 * 具体原型类,卡片类
 * @author: hutao
 * @date: 2021/10/20
 */
public class Card implements Cloneable{//实现Cloneable接口，Cloneable只是标识接口
    private int num; //卡号
    private Spec spec = new Spec();
    public Card(){
        System.out.println("执行Card构造");
    }
    public void setNum(int num) {
        this.num = num;
    }
    public void setSpec(int length, int width) {
        spec.setLength(length);
        spec.setWidth(width);
    }
    @Override
    public String toString() {
        return "Card{" +
                "num=" + num +
                ", spec=" + spec +
                '}';
    }
    /*@NonNull
    @Override
    public Card clone() throws CloneNotSupportedException {//重写clone()方法，clone()方法不是Cloneable接口里面的，而是Object里面的
        System.out.println("clone时不执行构造函数");
        return (Card) super.clone();  //浅拷贝
    }*/

    @NonNull
    @Override
    public Card clone() throws CloneNotSupportedException {//重写clone()方法，clone()方法不是Cloneable接口里面的，而是Object里面的
        System.out.println("clone时不执行构造函数");
        Card card = (Card) super.clone();
        card.spec = (Spec)spec.clone();//对spec对象也调用clone，实现深拷贝
        return card;  //浅拷贝
    }
}