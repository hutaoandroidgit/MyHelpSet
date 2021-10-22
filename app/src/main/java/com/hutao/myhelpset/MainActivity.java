package com.hutao.myhelpset;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hutao.helplibrary.Tool;
import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.mode.TestActivity;
import com.hutao.myhelpset.mode.action_mode.observermode.MilkConsumer;
import com.hutao.myhelpset.mode.action_mode.observermode.MilkFactory;
import com.hutao.myhelpset.tool.okhttp.OkHttpAcitvity;
import com.hutao.myhelpset.tool.annotation.RegisterView;
import com.hutao.myhelpset.tool.leakcanary.LeakCanaryAcitvity;
import com.hutao.myhelpset.tool.profiler.ProfilerAcitvity;
import com.hutao.myhelpset.tool.rxjava.RxJavaAcitvity;
import com.hutao.myhelpset.tool.rxjava.RxJavaDemoActivity;
import com.hutao.myhelpset.tool.rxjava.RxJavaHighLevelActivity;
import com.hutao.myhelpset.tool.rxjava.RxJavaRetrofitActivity;

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
    @RegisterView(id = R.id.testBtnOkHttp)
    private Button testBtnOkHttp;
    @RegisterView(id = R.id.testBtnRxjava)
    private Button testBtnRxjava;
    @RegisterView(id = R.id.testBtnRxjavaDemo)
    private Button testBtnRxjavaDemo;
    @RegisterView(id = R.id.testBtnRxjavaHighLevel)
    private Button testBtnRxjavaHighLevel;
    @RegisterView(id = R.id.testBtnRxjavaRetrofit)
    private Button testBtnRxjavaRetrofit;
    @RegisterView(id = R.id.testBtnModeTest)
    private Button testBtnModeTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //jitpack引用包测试
        //testJitPack();

        //LeakCanary检测工具测试
        //testLeakCanary();
        
        //Memory Profiler查找内存泄露
        //testProfiler();

        //Alibaba Java Guidelines日常编码 提示错误实例
        //testGuidelines();

        //okhttp使用测试 ，入门测试，后期使用kotlin以及框架理解
        //testOkHttp();

        //观察者模式了解 ，便于理解RxJava框架
        //testObserver();
        //测试Rxjava功能用法
        testRxJava();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        testBtnRxjavaDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxJavaDemoActivity.class);
            }
        });
    }
    
    /**
     * @description 测试RxJava
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/17 11:17
     */
    private void testRxJava() {
        testBtnRxjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxJavaAcitvity.class);
            }
        });
        testBtnRxjavaHighLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxJavaHighLevelActivity.class);
            }
        });
        testBtnRxjavaRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxJavaRetrofitActivity.class);
            }
        });
        testBtnModeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(TestActivity.class);
            }
        });
    }
    
    /**
     * @description 观察者模式
     * @param
     * @return
     * @author hutao
     * @time 2021/9/16 13:42
     */
    private void testObserver() {
        MilkConsumer consumer1 = new MilkConsumer("hutao");
        MilkConsumer consumer2 = new MilkConsumer("jmz");
        MilkFactory factory = new MilkFactory();
        //订阅过程
        factory.subscribe(consumer1);
        factory.subscribe(consumer2);
        OsduiLog.mtuiHintLog(TAG,"牛奶店已产出牛奶，通知发放顾客");
        //发布过程
        factory.onNext();
    }
    /**
     * @description okhttp使用测试
     * @param
     * @return
     * @author hutao
     * @time 2021/9/14 19:05
     */
    private void testOkHttp() {
        testBtnOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //模拟内存泄漏代码
                openActivity(OkHttpAcitvity.class);
            }
        });
        testBtnRxjavaRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(RxJavaRetrofitActivity.class);
            }
        });
    }
    /**
     * @description Alibaba Java Guidelines日常编码 提示错误实例
     * @param
     * @return
     * @author hutao
     * @time 2021/9/14 13:15
     */
    private void testGuidelines() {
        int type = 1;
        switch(type){
            case 0:

                break;
            case 1:

                break;
            case 2:
                break;
        }
        String str = "1";
        if (str.equals("1")){

        }else if (str.equals("2")){

        }
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