package com.hutao.myhelpset.tool.okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: hutao
 * @date: 2021/9/14
 */
public class OkHttpAcitvity extends BaseActivity {
    @RegisterView(id = R.id.testGet)
    private Button testGet;
    @RegisterView(id = R.id.testTvContent)
    private TextView testTvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_okhttp;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        testGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用同步请求
                OsduiLog.mtuiHintLog(TAG,"onClick synchro");
                synchro();
            }
        });
    }
    /**
     * @description get同步请求测试
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/14 19:12
     */
    private void synchro() {
        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient mOkHttpClient = new OkHttpClient(); //创建单例
                Request mRequest = new Request.Builder().url("http://www.sosoapi.com/pass/mock/12003/test/gettest").build(); //创建请求
                try {
                    Response mResponse = mOkHttpClient.newCall(mRequest).execute(); //执行情况
                    String mContent = mResponse.body().string();  // 返回响应内容 ，只能调用一次
                    OsduiLog.mtuiHintLog(TAG,"OkHttpClient"+mContent + "suc:"+mResponse.isSuccessful());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            testTvContent.setText(mContent);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
