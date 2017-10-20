package com.pujitech.wxgcommonhttp.modules.orders.classorder.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.orders.classorder.module.ClassOrderModule;
import com.pujitech.wxgcommonhttp.modules.orders.classorder.view.ClassOrderView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class ClassOrderPresenter extends BasePresenter<ClassOrderView, ClassOrderModule> {


    public ClassOrderPresenter(Context context) {
        super(context);
    }

    @Override
    protected ClassOrderModule initModule() {
        return new ClassOrderModule();
    }
}
