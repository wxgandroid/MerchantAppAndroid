package com.pujitech.wxgcommonhttp.modules.splash.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.pujitech.commonhttplibrary.bases.BaseActivity;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.login.activity.LoginActivity;
import com.pujitech.wxgcommonhttp.modules.splash.presenter.SplashPresenter;
import com.pujitech.wxgcommonhttp.modules.splash.view.SplashView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView, View.OnClickListener {

    @BindView(R2.id.tv_count_down)
    TextView tv_count_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mPresenter.loadTimeCount();
    }

    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }


    /**
     * 更新跳过按钮
     *
     * @param timeCount
     */
    @Override
    public void refreshTimeCountView(long timeCount) {
        tv_count_down.setText("(" + timeCount + ") 跳过");
    }


    /**
     * 跳转到登录页面
     */
    @Override
    public void jump2LoginActivity() {
        jump2Activity(LoginActivity.class);
    }

    @OnClick(R2.id.tv_count_down)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_count_down:
                mPresenter.interruptCount(false);
                break;
        }
    }

    @Override
    public void onDestroy() {
        mPresenter.interruptCount(true);
        super.onDestroy();
    }
}
