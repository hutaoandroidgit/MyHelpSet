package com.hutao.myhelpset.mode.structure_mode.proxymode;

/**
 * @author: hutao
 * @date: 2021/10/21
 */
public class Domestic implements People{
    @Override
    public void buy() {//具体实现
        System.out.println("国内要买一个包");
    }
}