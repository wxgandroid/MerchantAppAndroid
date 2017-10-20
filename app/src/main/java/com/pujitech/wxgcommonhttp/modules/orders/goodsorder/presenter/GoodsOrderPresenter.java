package com.pujitech.wxgcommonhttp.modules.orders.goodsorder.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.orders.goodsorder.module.GoodsOrderModule;
import com.pujitech.wxgcommonhttp.modules.orders.goodsorder.view.GoodsOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class GoodsOrderPresenter extends BasePresenter<GoodsOrderView,GoodsOrderModule>{


    public GoodsOrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected GoodsOrderModule initModule() {
        return new GoodsOrderModule();
    }
}
