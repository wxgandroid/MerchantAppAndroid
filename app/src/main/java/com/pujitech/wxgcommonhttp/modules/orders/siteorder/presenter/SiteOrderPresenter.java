package com.pujitech.wxgcommonhttp.modules.orders.siteorder.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.orders.siteorder.module.SiteOrderModule;
import com.pujitech.wxgcommonhttp.modules.orders.siteorder.view.SiteOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class SiteOrderPresenter extends BasePresenter<SiteOrderView, SiteOrderModule> {


    public SiteOrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected SiteOrderModule initModule() {
        return new SiteOrderModule();
    }
}
