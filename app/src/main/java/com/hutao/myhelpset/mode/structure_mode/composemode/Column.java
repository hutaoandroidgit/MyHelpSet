package com.hutao.myhelpset.mode.structure_mode.composemode;

import java.util.Iterator;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Column extends PageElement{//栏目 树节点
    public Column(String name) {
        super(name);
    }
    @Override
    public void addPageElement(PageElement pageElement) {
        mPageElements.add(pageElement);
    }
    @Override
    public void rmPageElement(PageElement pageElement) {
        mPageElements.remove(pageElement);
    }
    @Override
    public void clear() {
        mPageElements.clear();
    }
    /**
     * @param placeholder 占位符
     */
    @Override
    public void print(String placeholder) {
        //利用递归来打印文件夹结构
        System.out.println(placeholder + "└──" + getName());
        Iterator<PageElement> iterator = mPageElements.iterator();
        while (iterator.hasNext()){
            PageElement element = iterator.next();
            element.print(placeholder + "   ");
        }
    }
}