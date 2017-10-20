package com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.module.MerchantInfoModule;
import com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.view.MerchantInfoView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class MerchantInfoPresenter extends BasePresenter<MerchantInfoView,MerchantInfoModule>{
    public MerchantInfoPresenter(Context context) {
        super(context);
    }

    @Override
    protected MerchantInfoModule initModule() {
        return new MerchantInfoModule();
    }
}
