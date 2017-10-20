package com.pujitech.wxgcommonhttp.modules.main.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.main.module.MainModule;
import com.pujitech.wxgcommonhttp.modules.main.view.MainView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class MainPresenter extends BasePresenter<MainView, MainModule> {

    public MainPresenter(Context context) {
        super(context);
    }

    @Override
    protected MainModule initModule() {
        return new MainModule();
    }
}
