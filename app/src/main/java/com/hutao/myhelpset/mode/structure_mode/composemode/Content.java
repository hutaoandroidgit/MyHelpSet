package com.hutao.myhelpset.mode.structure_mode.composemode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Content extends PageElement{//具体内容 子节点

    public Content(String name) {
        super(name);
    }

    @Override
    public void addPageElement(PageElement pageElement) {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void rmPageElement(PageElement pageElement) {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("不支持此操作");
    }

    @Override
    public void print(String placeholder) {
        System.out.println(placeholder + "──" + getName());
    }
}