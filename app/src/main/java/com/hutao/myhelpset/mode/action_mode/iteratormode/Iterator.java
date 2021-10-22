package com.hutao.myhelpset.mode.action_mode.iteratormode;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public interface Iterator {
    boolean hasNext();//是否存在下一条记录
    Object next(); //返回当前记录并移到下一条记录
}
