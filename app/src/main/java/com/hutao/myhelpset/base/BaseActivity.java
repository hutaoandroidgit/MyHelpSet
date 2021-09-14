package com.hutao.myhelpset.base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hutao.helplibrary.log.MtuiLogcat;
import com.hutao.myhelpset.tool.annotation.RegisterEventManager;

/**
 * Base基类总结  (持续更新)
 * 1.监控生命周期（后期添加打印模块）
 * 2.界面跳转（openActivity 兼顾各种调用）
 * 3.初始化统一
 * @author: hutao
 * @date: 2021/9/8
 */
public abstract class BaseActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initContentValue();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    protected abstract int getLayoutResId();
    /**
     * 对ContentView的初始化值：findViews(), initContentComponentValue(),
     * createListeners();
     *
     * <pre>
     * Note:已经在setContentView()之后被调用
     * </pre>
     */
    protected void initContentValue() {
        MtuiLogcat.getInstance().setLogType(1);
        RegisterEventManager.findViewsById(getWindow().getDecorView(),this);
        findViews();
        initContentComponentValue();
        createListeners();
    }

    /**
     * 初始化设置(由于注解不在必须实现)
     */
    protected abstract void initContentComponentValue();
    /**
     * 初始化控件(由于注解不在必须实现)
     */
    protected void findViews(){}
    /**
     * 设置监听器
     */
    protected abstract void createListeners();




    /**
     * 打开一个Activity
     * <p>
     * 默认从右边进入，左边出去
     * </p>
     *
     * @param pClass
     */
    public void openActivity(Class<?> pClass) {
        openActivity(pClass, null, -1, -1, -1);
    }

    /**
     * 打开一个Activity
     *
     * @param pClass
     * @param enterAnim
     *             进入动画
     * @param exitAnim
     *            退出动画
     */
    public void openActivity(Class<?> pClass, int enterAnim, int exitAnim) {
        openActivity(pClass, null, -1, enterAnim, exitAnim);
    }

    /**
     * 打开一个Activity
     * <p>
     * 默认从右边进入，左边出去
     * </p>
     *
     * @param pClass
     * @param requestCode
     */
    public void openActivity(Class<?> pClass, int requestCode) {
        openActivity(pClass, null, requestCode, -1, -1);
    }

    /**
     * 打开一个Activity
     *
     * @param pClass
     * @param requestCode
     * @param enterAnim
     *           进入动画
     * @param exitAnim
     *            退出动画
     */
    public void openActivity(Class<?> pClass, int requestCode, int enterAnim, int exitAnim) {
        openActivity(pClass, null, requestCode, enterAnim, exitAnim);
    }

    /**
     * 打开一个Activity
     *
     * @param intent
     * @param requestCode
     * @param enterAnim
     * @param exitAnim
     */
    public void openActivity(Intent intent, int requestCode, int enterAnim, int exitAnim) {
        if (requestCode < 0) {
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            startActivityForResult(intent, requestCode);
            overridePendingTransition(0, 0);
        }

        if (enterAnim > 0 && exitAnim > 0) {
            overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * 打开一个Activity
     *
     * @param pClass
     * @param pBundle
     * @param requestCode
     */
    public void openActivity(Class<?> pClass, Bundle pBundle, int requestCode, int enterAnim, int exitAnim) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }

        if (requestCode < 0) {
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            startActivityForResult(intent, requestCode);
            overridePendingTransition(0, 0);
        }

        if (enterAnim > 0 && exitAnim > 0) {
            overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * 打开一个Activity
     *
     * @param pAction
     * @param requestCode
     */
    public void openActivity(String pAction, int requestCode) {
        openActivity(pAction, null, requestCode);
    }

    /**
     * 打开一个Activity
     *
     * @param pClass
     * @param pBundle
     */
    public void openActivity(Class<?> pClass, Bundle pBundle) {
        openActivity(pClass, pBundle, -1, -1, -1);
    }

    /**
     * 打开一个Activity
     *
     * @param pAction
     * @param pBundle
     * @param requestCode
     */
    public void openActivity(String pAction, Bundle pBundle, int requestCode) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }

        if (requestCode < 0) {
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            startActivityForResult(intent, requestCode);
            overridePendingTransition(0, 0);
        }
    }

    /**
     * 打开一个Activity
     *
     * @param pClass
     * @param pBundle
     * @param requestCode
     */
    public void openActivity(Class<?> pClass, Bundle pBundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }

        if (requestCode < 0) {
            startActivity(intent);
            overridePendingTransition(0, 0);
        } else {
            startActivityForResult(intent, requestCode);
            overridePendingTransition(0, 0);
        }
    }
}
