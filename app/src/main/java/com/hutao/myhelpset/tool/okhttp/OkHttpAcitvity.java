package com.hutao.myhelpset.tool.okhttp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author: hutao
 * @date: 2021/9/14
 */
public class OkHttpAcitvity extends BaseActivity {
    @RegisterView(id = R.id.testSynchroGet)
    private Button testSynchroGet;
    @RegisterView(id = R.id.testAsynchronousGet)
    private Button testAsynchronousGet;
    @RegisterView(id = R.id.testSynchroPost)
    private Button testSynchroPost;
    @RegisterView(id = R.id.testAsynchronousPost)
    private Button testAsynchronousPost;
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
        testSynchroGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get调用同步请求
                synchro();
            }
        });
        testAsynchronousGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get调用异步请求
                asynchronous();
            }
        });
        testSynchroPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //post同步请求
                postSynchro();
            }
        });
        testAsynchronousPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postAsynchronous();
            }
        });
    }
    /**
     * @description post 异步请求
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/15 11:26
     */
    private void postAsynchronous() {
        //创建单例
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建post请求数据表单
        RequestBody requestBody = new FormBody.Builder()
                .add("name","请求post")
                .add("password","123456")
                .build();
        //创建请求
        final Request request = new Request.Builder()
                .url("http://www.sosoapi.com/pass/mock/20761/mytest/posttest1")
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //失败回调
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String mContent = readJSONContent2(response.body().string());
                //这里已经在子线程
                if(response.isSuccessful()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //因为在子线程,所以我们需要回到主线程中更新UI数据
                            testTvContent.setText(mContent);
                        }
                    });
                }
            }
        });
    }

    /**
     * @description post 同步请求
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/15 10:57
     */
    private void postSynchro() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //实例
                OkHttpClient okHttpClient = new OkHttpClient();
                //创建post请求数据表单
                RequestBody requestBody = new FormBody.Builder()
                        .add("name","请求post")
                        .add("password","123456")
                        .build();
                //创建请求
                final Request request = new Request.Builder()
                        .url("http://www.sosoapi.com/pass/mock/20761/mytest/posttest1")
                        .post(requestBody)//添加post请求
                        .build();
                try {
                    //发送请求得到响应
                    final Response response = okHttpClient.newCall(request).execute();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                testTvContent.setText(readJSONContent2(response.body().string()));//注意response.body().string() 只能调用一次！
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    /**
     * @description Get异步请求
     * @param 
     * @return 
     * @author hutao
     * @time 2021/9/15 10:10
     */
    private void asynchronous() {
        //创建单例
        OkHttpClient mOkHttpClient = new OkHttpClient();
        //创建请求
        Request mRequest = new Request.Builder().url("http://www.sosoapi.com/pass/mock/20761/mytest/gettest1").build();
        mOkHttpClient.newCall(mRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //失败回调
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String mContent = readJSONContent(response.body().string());//注意response.body().string() 只能调用一次！
                //这里已经在子线程
                if(response.isSuccessful()){
                    //isSuccessful方法：如果代码位于（200…300）中，则返回true，这意味着请求已成功接收
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //因为在子线程,所以我们需要回到主线程中更新UI数据
                            testTvContent.setText(mContent);
                        }
                    });
                }
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
                //创建单例
                OkHttpClient mOkHttpClient = new OkHttpClient();
                //创建请求
                Request mRequest = new Request.Builder().url("http://www.sosoapi.com/pass/mock/20761/mytest/gettest1").build();
                try {
                    //execute方法 同步请求 等待获取Response结果 该方法必须在子线程中 请求成功后需要跳转到UI线程修改UI。
                    Response mResponse = mOkHttpClient.newCall(mRequest).execute(); //执行情况
                    //1.response.body().string()本质是输入流的读操作，所以它还是网络请求的一部分，所以这行代码必须放在子线程。
                    //2.response.body().string()只能调用一次，在第一次时有返回值，第二次再调用时将会返回null。
                    // 原因是：response.body().string()的本质是输入流的读操作，必须有服务器的输出流的写操作时客户端的读操作才能得到数据。
                    // 而服务器的写操作只执行一次，所以客户端的读操作也只能执行一次，第二次将返回null
                    String mContent = mResponse.body().string();
                    OsduiLog.mtuiHintLog(TAG,"OkHttpClient"+mContent + "suc:"+mResponse.isSuccessful());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            testTvContent.setText(readJSONContent(mContent));
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mThread.start();
    }

    /**
     * JSON 解析方法
     * @param jsonData
     * @return
     */
    public String readJSONContent(String jsonData){
        try {
            StringBuffer sb = new StringBuffer();
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                sb.append(jsonObject.getString("name")+"\n");
                sb.append(jsonObject.getString("content")+"\n");
            }
            return sb.toString();
        } catch (JSONException e) {
            OsduiLog.mtuiErrorLog("JSONException错误", "readContent: "+e.toString());
            return e.toString();
        }
    }

    public String readJSONContent2(String jsonData){
        try {
            StringBuffer sb = new StringBuffer();
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                sb.append(jsonObject.getString("result")+"\n");
            }
            return sb.toString();
        } catch (JSONException e) {
            OsduiLog.mtuiErrorLog("JSONException错误", "readContent: "+e.toString());
            return e.toString();
        }
    }
}
