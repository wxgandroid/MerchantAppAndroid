package com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.activity;

import android.os.Bundle;

import com.pujitech.commonhttplibrary.bases.BaseActivity;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.presenter.MerchantInfoPresenter;
import com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.view.MerchantInfoView;

public class MerchantInfoActivity extends BaseActivity<MerchantInfoPresenter> implements MerchantInfoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_info);
    }

    @Override
    public MerchantInfoPresenter createPresenter() {
        return new MerchantInfoPresenter(this);
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }
}
