package com.pujitech.wxgcommonhttp.modules.orders.serviceorder.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.orders.serviceorder.module.ServiceOrderModule;
import com.pujitech.wxgcommonhttp.modules.orders.serviceorder.view.ServiceOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ServiceOrderPresenter extends BasePresenter<ServiceOrderView, ServiceOrderModule> {

    public ServiceOrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected ServiceOrderModule initModule() {
        return new ServiceOrderModule();
    }
}
