package com.pujitech.commonhttplibrary.bases;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.pujitech.commonhttplibrary.CommonObserver;
import com.pujitech.commonhttplibrary.RxLifeRecycle;
import com.pujitech.commonhttplibrary.utils.DialogUtils;
import com.zhy.autolayout.AutoLayoutActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AutoLayoutActivity implements BaseView, RxLifeRecycle {

    protected T mPresenter;
    private Dialog mIosLoading;
    protected Intent mIntent;
    private long mLastBackTime;

    public boolean mDoubleClickExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            attachView();
        }
    }

    /**
     * presenter赋值
     *
     * @return
     */
    public abstract T createPresenter();


    /**
     * 给presenter绑定view
     */
    public abstract void attachView();


    /**
     * Toast 消息
     *
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        Toast.makeText(BaseActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示加载网络的进度条
     */
    @Override
    public void showProgressBar() {
        mIosLoading = DialogUtils.showIosLoading(this, new DialogUtils.OnKeyBackListener() {
            @Override
            public void onKeyBack() {

            }
        });
    }

    /**
     * 隐藏加载网络的进度条
     */
    @Override
    public void dismissProgressBar() {
        if (mIosLoading != null) {
            mIosLoading.dismiss();
        }
    }

    /**
     * 管理联网操作的生命周期
     */
    @Override
    public void onDestroy() {
        for (CommonObserver observer : mObservers) {
            if (observer != null) {
                observer.onDestroy();
            }
        }
        super.onDestroy();
    }

    /**
     * 将联网的observer对象添加到集合中
     *
     * @param observer
     */
    @Override
    public void setRegisterObject(CommonObserver observer) {
        mObservers.add(observer);
    }


    /**
     * 跳转到其他页面
     */
    public <T extends Activity> void jump2Activity(Class<T> tClass) {
        if (mIntent == null) {
            mIntent = new Intent();
        }
        mIntent.setClass(this, tClass);
        startActivity(mIntent);
        finish();
    }


    @Override
    public void onBackPressed() {
        if (mDoubleClickExit) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - mLastBackTime > 2000) {
                //两次返回间隔大于2s
                mLastBackTime = currentTime;
                showToast("再次点击退出应用");
                return;
            }
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }

    }
}
