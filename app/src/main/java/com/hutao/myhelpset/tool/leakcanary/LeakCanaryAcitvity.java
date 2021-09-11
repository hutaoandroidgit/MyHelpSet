package com.hutao.myhelpset.tool.leakcanary;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hutao.myhelpset.R;
import com.hutao.myhelpset.base.BaseActivity;
import com.hutao.myhelpset.tool.annotation.RegisterView;

/**
 * 测试内存泄漏工具LeakCanaryA
 * @author: hutao
 * @date: 2021/9/8
 */
public class LeakCanaryAcitvity extends BaseActivity {
    @RegisterView(id = R.id.testBtn)
    private Button testBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(LeakCanaryAcitvity.this,"检测内存泄漏");
            }
        });
    }

    @Override
    protected void initContentComponentValue() {

    }

    @Override
    protected void createListeners() {

    }
}
