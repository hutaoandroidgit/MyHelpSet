package com.hutao.myhelpset;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hutao.helplibrary.Tool;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;
import com.hutao.myhelpset.tool.leakcanary.LeakCanaryAcitvity;
import com.hutao.myhelpset.tool.profiler.ProfilerAcitvity;

/**
 * @description 测试主act入口
 * @param 
 * @return 
 * @author hutao
 * @time 2021/9/6 17:00
 */
public class MainActivity extends BaseActivity {
    @RegisterView(id = R.id.testBtnLeakCanary)
    private Button testBtnLeakCanary;
    @RegisterView(id = R.id.testBtnProfiler)
    private Button testBtnProfiler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //jitpack引用包测试
        //testJitPack();

        //LeakCanary检测工具测试
        //testLeakCanary();
        
        //Memory Profiler查找内存泄露
        //testProfiler();
    }



    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {

    }
    /**
     * @description Memory Profiler查找内存泄露实例测试
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/14 9:30
     */
    private void testProfiler() {
        testBtnProfiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟内存泄漏代码
                openActivity(ProfilerAcitvity.class);
            }
        });
    }
    /**
     * @description LeakCanary检测工具测试  模拟内存泄漏代码进行测试
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/6 16:58
     */
    private void testLeakCanary() {
        testBtnLeakCanary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟内存泄漏代码
                openActivity(LeakCanaryAcitvity.class);
            }
        });
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