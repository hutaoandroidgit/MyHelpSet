package com.hutao.myhelpset.mode.structure_mode.composemode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public abstract class PageElement {//页面
    protected List<PageElement> mPageElements = new ArrayList<>();

    private String name;

    public PageElement(String name) {
        this.name = name;
    }

    public abstract void addPageElement(PageElement pageElement);//添加栏目或者具体内容
    public abstract void rmPageElement(PageElement pageElement);//删除栏目或者具体内容
    public abstract void clear();//清空所有元素
    public abstract void print(String placeholder);//打印页面结构

    public String getName() {
        return name;
    }
}