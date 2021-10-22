package com.hutao.myhelpset.tool.rxjava.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.tool.rxjava.mvp.base.MvpActivity;
import com.hutao.myhelpset.tool.rxjava.mvp.presenter.CustomPersenter;
import com.hutao.myhelpset.tool.rxjava.mvp.view.CustomView;

/**
 * @author: hutao
 * @date: 2021/10/18
 */
public class RealViewActivity extends MvpActivity<RealPersenter> implements CustomView {
    private TextView textView;
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        textView = findViewById(R.id.textshowcontent);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //按钮点击获取数据
                presenter.loadData();
            }
        });
    }

    @Override
    protected RealPersenter creatPresenter() {
        return new RealPersenter();
    }

    @Override
    public void onLoading(String text) {
        textView.append(text);
    }

    @Override
    public void onRefreshData(String text) {
        textView.append(text);
    }

    @Override
    public void onError(String text) {
        textView.append(text);
    }

    @Override
    public void onComplete(String text) {
        textView.append(text);
    }

}