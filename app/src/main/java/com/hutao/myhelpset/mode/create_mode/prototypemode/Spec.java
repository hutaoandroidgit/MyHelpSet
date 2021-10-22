package com.hutao.myhelpset.mode.create_mode.prototypemode;

/**
 * 规格类，有长和宽这两个属性
 * @author: hutao
 * @date: 2021/10/20
 */
public class Spec implements Cloneable{
    private int width;
    private int length;
    public void setWidth(int width) {
        this.width = width;
    }
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public String toString() {
        return "Spec{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
    @Override
    protected Spec clone() throws CloneNotSupportedException {//重写Spec的clone方法
        return (Spec) super.clone();
    }
}