package com.hutao.myhelpset.mode.action_mode.commondmode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class ShutdownCommand implements Command {//关机命令
    private Receiver receiver;//接受者

    public ShutdownCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("命令角色执行关机命令");
        receiver.action();
    }
}