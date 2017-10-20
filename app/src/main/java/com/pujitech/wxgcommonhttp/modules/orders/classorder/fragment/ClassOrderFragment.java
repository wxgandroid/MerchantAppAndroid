package com.pujitech.wxgcommonhttp.modules.orders.classorder.fragment;

import android.content.Context;
import android.view.View;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.modules.orders.classorder.presenter.ClassOrderPresenter;
import com.pujitech.wxgcommonhttp.modules.orders.classorder.view.ClassOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ClassOrderFragment extends BaseFragment<ClassOrderPresenter> implements ClassOrderView {
    @Override
    protected void initData() {

    }

    @Override
    protected View inflateView() {
        return null;
    }

    @Override
    protected ClassOrderPresenter createPresenter(Context context) {
        return new ClassOrderPresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
    }
}
