package com.pujitech.wxgcommonhttp.modules.orders.siteorder.fragment;

import android.content.Context;
import android.view.View;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.modules.orders.siteorder.presenter.SiteOrderPresenter;
import com.pujitech.wxgcommonhttp.modules.orders.siteorder.view.SiteOrderView;

import butterknife.ButterKnife;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class SiteOrderFragment extends BaseFragment<SiteOrderPresenter> implements SiteOrderView {


    @Override
    protected void initData() {

    }

    @Override
    protected View inflateView() {
        return null;
    }

    @Override
    protected SiteOrderPresenter createPresenter(Context context) {
        return new SiteOrderPresenter(mContext);
    }


    @Override
    protected void attachView() {
        mPresenter.attachView(this);
        ButterKnife.bind(this, mRootView);
    }
}
