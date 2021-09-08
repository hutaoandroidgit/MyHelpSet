package com.hutao.myhelpset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hutao.helplibrary.Tool;
/**
 * @description 测试主act入口
 * @param 
 * @return 
 * @author hutao
 * @time 2021/9/6 17:00
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //jitpack引用包测试
        //testJitPack();


        //LeakCanary检测工具测试
        testLeakCanary();
    }

    /**
     * @description LeakCanary检测工具测试  模拟内存泄漏代码进行测试
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/6 16:58
     */
    private void testLeakCanary() {

    }

    /**
     * @description jitpack引用包测试  implementation 'com.github.hutaoandroidgit:MyHelpSet:1.0.2'
     * @param
     * @return
     * @author hutao
     * @time 2021/9/6 16:57
     */
    private void testJitPack() {
        Tool tool = new Tool();
        tool.setTag("1111");
    }
}