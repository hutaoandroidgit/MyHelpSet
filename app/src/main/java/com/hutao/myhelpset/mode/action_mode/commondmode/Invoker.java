package com.hutao.myhelpset.mode.action_mode.commondmode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Invoker {//调用者
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void action() {
        System.out.println("调用者执行命令");
        command.execute();
    }
}