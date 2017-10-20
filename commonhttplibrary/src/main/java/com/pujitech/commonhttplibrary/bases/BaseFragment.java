package com.pujitech.commonhttplibrary.bases;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pujitech.commonhttplibrary.CommonObserver;
import com.pujitech.commonhttplibrary.RxLifeRecycle;
import com.pujitech.commonhttplibrary.utils.DialogUtils;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView, RxLifeRecycle {

    public View mRootView;
    public T mPresenter;
    public Context mContext;
    private Dialog mIosLoading;
    public Intent mIntent;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    /**
     * 根据传入的fragment类型，返回相应的fragment
     *
     * @param t
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws java.lang.InstantiationException
     */
    public static <T extends BaseFragment> T createFragment(Class<T> t) {
        T fragment = null;
        try {
            fragment = t.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        mRootView = inflateView();
        mPresenter = createPresenter(mContext);
        if (mPresenter != null) {
            attachView();
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();


    /**
     * 给fragment设置布局
     *
     * @return
     */
    protected abstract View inflateView();


    /**
     * 给当前fragment设定相应的presenter
     *
     * @param context
     * @return
     */
    protected abstract T createPresenter(Context context);

    /**
     * 给presenter绑定view
     */
    protected abstract void attachView();


    /**
     * Toast 消息
     *
     * @param msg
     */
    @Override
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示加载网络的进度条
     */
    @Override
    public void showProgressBar() {
        mIosLoading = DialogUtils.showIosLoading(mContext, new DialogUtils.OnKeyBackListener() {
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
        mIntent.setClass(mContext, tClass);
        startActivity(mIntent);
    }

}
