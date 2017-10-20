package com.pujitech.commonhttplibrary.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import com.pujitech.commonhttplibrary.R;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public class DialogUtils {

    /**
     * 仿ios菊花效果的loading
     *
     * @param context
     */
    public static Dialog showIosLoading(Context context, final OnKeyBackListener onKeyBackListener) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (100 * density), (int) (100 * density));

        final Dialog dialog = new Dialog(context, R.style.Theme_NoTitleBarDialog);

        View view = View.inflate(context, R.layout.ios_loading_layout, null);
        dialog.setContentView(view, params);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                    //点击了返回键
                    if (onKeyBackListener != null) {
                        onKeyBackListener.onKeyBack();
                        return true;
                    }
                }
                return false;
            }
        });

        dialog.show();
        return dialog;
    }


    /**
     * 点击返回按钮的监听
     */
    public interface OnKeyBackListener {
        void onKeyBack();
    }
}
