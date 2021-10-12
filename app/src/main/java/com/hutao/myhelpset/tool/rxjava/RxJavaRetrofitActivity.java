package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

/**
 * @author: hutao
 * @date: 2021/10/12
 */
public class RxJavaRetrofitActivity extends BaseActivity {
    @RegisterView(id = R.id.btnRetrofit)
    private Button btnRetrofit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_rxjava_retrofit;
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {
        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}