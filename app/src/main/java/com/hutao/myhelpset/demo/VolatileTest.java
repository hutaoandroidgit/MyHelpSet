package com.hutao.myhelpset.demo;

/**
 * @author: hutao
 * @date: 2021/10/19
 */
public class VolatileTest extends Thread{
    public volatile boolean flag = false;
    public int i = 0;

    @Override
    public void run() {
        while (!flag){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.start();
        Thread.sleep(2000);
        volatileTest.flag = true;
        System.out.println("stope" + volatileTest.i);
    }
}