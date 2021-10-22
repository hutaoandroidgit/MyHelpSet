package com.hutao.myhelpset;

import com.hutao.myhelpset.demo.VolatileTest;
import com.hutao.myhelpset.mode.create_mode.singelmode.Singleton;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void test1() throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.start();
        Thread.sleep(10);
        volatileTest.flag = true;
        System.out.println("stope" + volatileTest.i);
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor con = Singleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        // 通过反射获取实例
        Singleton singeton1 = (Singleton) con.newInstance();
        Singleton singeton2 = (Singleton) con.newInstance();
        System.out.println(singeton1==singeton2);//结果为false,singeton1和singeton2将是两个不同的实例
    }
}