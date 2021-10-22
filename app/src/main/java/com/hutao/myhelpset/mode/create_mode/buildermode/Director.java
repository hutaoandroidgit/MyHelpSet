package com.hutao.myhelpset.mode.create_mode.buildermode;

/**
 * 定义指挥者类（Director）：老板委派任务给装机人员
 * @author: hutao
 * @date: 2021/10/19
 */
public class Director {
    private Builder builder = null;

    public Director(Builder builder) {
        this.builder = builder;
    }
    //指挥装机人员组装电脑
    public Computer Construct(String cpu,String memory ,String hd){
        builder.buildCPU(cpu);
        builder.buildMemory(memory);
        builder.buildHD(hd);
        return builder.create();
    }
}