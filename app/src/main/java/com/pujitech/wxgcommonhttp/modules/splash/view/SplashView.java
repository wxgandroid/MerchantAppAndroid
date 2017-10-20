package com.pujitech.wxgcommonhttp.modules.splash.view;

import com.pujitech.commonhttplibrary.bases.BaseView;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public interface SplashView extends BaseView {

    /**
     * 刷新倒计时的文本
     */

    void refreshTimeCountView(long timeCount);

    /**
     * 跳转到登录页面
     */
    void jump2LoginActivity();
}
