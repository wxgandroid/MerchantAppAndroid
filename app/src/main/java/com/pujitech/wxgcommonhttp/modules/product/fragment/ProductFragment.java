package com.pujitech.wxgcommonhttp.modules.product.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.commonhttplibrary.utils.LogUtils;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.modules.product.presenter.ProductPresenter;
import com.pujitech.wxgcommonhttp.modules.product.view.ProductView;

import butterknife.ButterKnife;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ProductFragment extends BaseFragment<ProductPresenter> implements ProductView {
    private final String TAG = ProductFragment.class.getSimpleName();

    @Override
    protected void initData() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            LogUtils.i(TAG, "onHiddenChanged");
        }
    }

    @Override
    protected View inflateView() {
        return LayoutInflater.from(mContext).inflate(R.layout.fragment_product, null);
    }

    @Override
    protected ProductPresenter createPresenter(Context context) {
        return new ProductPresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
        ButterKnife.bind(this, mRootView);
    }
}
