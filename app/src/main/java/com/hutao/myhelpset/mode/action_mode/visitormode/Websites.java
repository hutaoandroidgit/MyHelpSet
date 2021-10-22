package com.hutao.myhelpset.mode.action_mode.visitormode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Websites {
    public List<Web> webs = new ArrayList<>();//元素集合

    public void acceptAll(Visitor visitor){
        Iterator<Web> iterator = webs.iterator();
        while (iterator.hasNext()){//迭代遍历访问
            iterator.next().accept(visitor);
        }
    }

    public void addWeb(Web web){
        webs.add(web);
    }
}