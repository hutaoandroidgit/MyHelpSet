package com.hutao.myhelpset.tool.rxjava;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

/**
 * @author: hutao
 * @date: 2021/9/30
 */
public class RxJavaDemoActivity extends BaseActivity {
    @RegisterView(id = R.id.btnCode)
    private Button btnCode;
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

    }

    @Override
    protected void createListeners() {

    }
}