package com.pujitech.wxgcommonhttp.modules.setting.home.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.setting.home.module.SettingModule;
import com.pujitech.wxgcommonhttp.modules.setting.home.view.SettingView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class SettingPresenter extends BasePresenter<SettingView, SettingModule> {
    public SettingPresenter(Context context) {
        super(context);
    }

    @Override
    protected SettingModule initModule() {
        return new SettingModule();
    }
}
