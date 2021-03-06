package com.hutao.myhelpset.tool.leakcanary;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hutao.myhelpset.R;

/**
 * @author: hutao
 * @date: 2021/9/8
 */
public class ToastUtil {

    private static Toast mToast;

    public static void showToast(Context context, int resId) {
        String text = context.getString(resId);
        showToast(context, text);
    }

    public static void showToast(Context context, String text){
        showToast(context, text, Gravity.BOTTOM);
    }

    public static void showToastCenter(Context context, String text){
        showToast(context, text, Gravity.CENTER);
    }

    public static void showToast(Context context, String text, int gravity){
        cancelToast();
        if (context != null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.toast_layout, null);
            ((TextView) layout.findViewById(R.id.tv_toast_text)).setText(text);
            mToast = new Toast(context);
            mToast.setView(layout);
            mToast.setGravity(gravity, 0, 20);
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.show();
        }
    }

    public static void cancelToast() {
        if (mToast != null){
            mToast.cancel();
        }
    }
}