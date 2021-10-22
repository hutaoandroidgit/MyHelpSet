package com.hutao.myhelpset.mode.action_mode.mementomode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Caretaker {//备忘录管理类
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}