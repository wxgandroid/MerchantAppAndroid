package com.pujitech.wxgcommonhttp.modules.product.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.product.module.ProductModule;
import com.pujitech.wxgcommonhttp.modules.product.view.ProductView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ProductPresenter extends BasePresenter<ProductView, ProductModule> {
    public ProductPresenter(Context context) {
        super(context);
    }

    @Override
    protected ProductModule initModule() {
        return new ProductModule();
    }
}
