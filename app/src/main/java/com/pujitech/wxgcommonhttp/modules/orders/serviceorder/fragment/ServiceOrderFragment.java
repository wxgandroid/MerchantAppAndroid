package com.pujitech.wxgcommonhttp.modules.orders.serviceorder.fragment;

import android.content.Context;
import android.view.View;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.modules.orders.serviceorder.presenter.ServiceOrderPresenter;
import com.pujitech.wxgcommonhttp.modules.orders.serviceorder.view.ServiceOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ServiceOrderFragment extends BaseFragment<ServiceOrderPresenter> implements ServiceOrderView {
    @Override
    protected void initData() {

    }

    @Override
    protected View inflateView() {
        return null;
    }

    @Override
    protected ServiceOrderPresenter createPresenter(Context context) {
        return new ServiceOrderPresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
    }
}
