package com.hutao.myhelpset.tool.rxjava;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Rxjava项目模拟实战
 * @author: hutao
 * @date: 2021/9/30
 */
public class RxJavaDemoActivity extends BaseActivity {
    @RegisterView(id = R.id.btnCode)
    private Button btnCode;
    //定义倒计时长度
    private int count = 59;
    @RegisterView(id = R.id.btnView)
    private Button btnView;

    @RegisterView(id = R.id.btnGet1)
    private Button btnGet1;
    @RegisterView(id = R.id.btnGet2)
    private Button btnGet2;
    @RegisterView(id = R.id.btnGet3)
    private Button btnGet3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rxjavademo;
    }

    @Override
    protected void initContentComponentValue() {
        //模拟验证码发送倒计时
        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable
                        //定时1秒发送 其实无延迟
                        .interval(0,1, TimeUnit.SECONDS)
                        //取60个数值 01,2,3...59
                        .take(count + 1)
                        .map(new Function<Long, Long>() {
                            @Override
                            public Long apply(@NonNull Long aLong) throws Exception {
                                return count - aLong;  //map将值转化为倒着发送
                            }
                        })
                        //接收的处理在UI线程
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                //订阅监听开始的时候就置灰按钮 无法点击
                                btnCode.setEnabled(false);
                                btnCode.setTextColor(Color.BLACK);
                            }
                        }).subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        //显示倒计时
                        btnCode.setText("剩余"+"("+aLong+")");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        //发送结束就设置回来按钮状态
                        btnCode.setEnabled(true);
                        btnCode.setTextColor(Color.WHITE);
                        btnCode.setText("发送验证码");
                    }
                });
            }
        });
        //按键防暴力点击做法
        RxUilts.click(btnView,2).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Object o) {
                OsduiLog.mtuiHintLog(TAG,"########Observer onNext######## click");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                OsduiLog.mtuiHintLog(TAG,"########Observer onComplete########");
            }
        });
        //模拟用户VIP数据查询

    }

    @Override
    protected void createListeners() {
        btnGet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OsduiLog.mtuiHintLog(TAG,"第一次查询：" );
                List<Long> uids = new ArrayList<>();
                uids.add(1L);
                uids.add(2L);
                getVipFromCache(uids);
            }
        });
        btnGet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OsduiLog.mtuiHintLog(TAG,"第二次查询：" );
                List<Long> uids = new ArrayList<>();
                uids.add(1L);
                uids.add(3L);
                uids.add(4L);
                getVipFromCache(uids);
            }
        });
        btnGet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OsduiLog.mtuiHintLog(TAG,"第三次查询：" );
                List<Long> uids = new ArrayList<>();
                uids.add(1L);
                uids.add(2L);
                uids.add(3L);
                uids.add(4L);
                getVipFromCache(uids);
                mVipCache.clear();
            }
        });
    }

    private HashMap<Long,Vip> mVipCache = new HashMap<>();
    public static class Vip{
        //vip信息实体类
    }
    
    /**
     * @description 获取缓存VIP，缓存没有就请求web
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/11 14:45
     */
    public Observable<HashMap<Long,Vip>> getVipFromCache(List<Long> uids){
        List<Long> mRequestList = new ArrayList<>();
        HashMap<Long,Vip> vipInfo = new HashMap<>();

        for (Long uid : uids){
            if (mVipCache.containsKey(uid)){
                OsduiLog.mtuiHintLog(TAG,"从本地缓存获取数据：" + uid + "用户");
                vipInfo.put(uid,mVipCache.get(uid));
            }else{
                OsduiLog.mtuiHintLog(TAG,"从网络获取数据：" + uid + "用户");
                mRequestList.add(uid);
            }
        }
        if (mRequestList.isEmpty()){
            //如果网络请求列表为空，返回缓存列表
            return Observable.just(vipInfo);
        }
        return Observable.merge(Observable.just(vipInfo),getVipFromWeb(mRequestList));
    }

    /**
     * @description 请求web vip数据
     * @param 
     * @return 
     * @author hutao
     * @time 2021/10/11 14:45
     */
    private Observable<HashMap<Long,Vip>> getVipFromWeb(List<Long> uids) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟网络返回数据
        HashMap<Long,Vip> vipHashMap = new HashMap<>();
        for (Long uid : uids){
            Vip item = new Vip();
            //item.xxx = ...;
            //item.xxx = ...;
            vipHashMap.put(uid,item);
        }
        //缓存到本地
        mVipCache.putAll(vipHashMap);

        return Observable.just(vipHashMap);
    }
}