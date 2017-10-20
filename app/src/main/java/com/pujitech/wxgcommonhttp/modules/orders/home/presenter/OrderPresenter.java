package com.pujitech.wxgcommonhttp.modules.orders.home.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.orders.home.module.OrderModule;
import com.pujitech.wxgcommonhttp.modules.orders.home.view.OrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class OrderPresenter extends BasePresenter<OrderView, OrderModule> {

    public OrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected OrderModule initModule() {
        return new OrderModule();
    }
}
