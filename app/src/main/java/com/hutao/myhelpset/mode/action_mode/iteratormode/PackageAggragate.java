package com.hutao.myhelpset.mode.action_mode.iteratormode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hutao
 * @date: 2021/10/20
 */
public class PackageAggragate implements Aggragate{
    private List<String> list = new ArrayList<>();//内部使用list来存储数据
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String get(int index) {
        return list.get(index);
    }

    @Override
    public void add(String tel) {
        list.add(tel);
    }

    @Override
    public void remove(String tel) {
        list.remove(tel);
    }

    @Override
    public Iterator iteretor() {//返回迭代器
        return new PackageIteretor(this);
    }
}