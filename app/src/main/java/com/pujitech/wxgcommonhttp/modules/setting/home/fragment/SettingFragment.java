package com.pujitech.wxgcommonhttp.modules.setting.home.fragment;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.setting.home.presenter.SettingPresenter;
import com.pujitech.wxgcommonhttp.modules.setting.home.view.SettingView;
import com.pujitech.wxgcommonhttp.modules.setting.merchantinfo.activity.MerchantInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by WangXuguang on 2017/10/19.
 */

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingView, View.OnClickListener {

    @BindView(R2.id.tv_mechant_info)
    TextView tv_mechant_info;               //商家资料
    @BindView(R2.id.tv_business_setting)
    TextView tv_business_setting;           //营业设置
    @BindView(R2.id.tv_message_remind)
    TextView tv_message_remind;             //消息提醒
    @BindView(R2.id.tv_edit_password)
    TextView tv_edit_password;              //修改密码
    @BindView(R2.id.tv_cancel_user)
    TextView tv_cancel_user;                //注销账号


    @Override
    protected void initData() {

    }

    @Override
    protected View inflateView() {
        return LayoutInflater.from(mContext).inflate(R.layout.fragment_setting, null);
    }

    @Override
    protected SettingPresenter createPresenter(Context context) {
        return new SettingPresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
        ButterKnife.bind(this, mRootView);
    }

    @OnClick({R2.id.tv_mechant_info, R2.id.tv_business_setting, R2.id.tv_message_remind, R2.id.tv_edit_password, R2.id.tv_cancel_user})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_mechant_info:
                //商家资料
                startMechantInfo();
                break;
            case R.id.tv_business_setting:
                //营业设置
                startBusinessSetting();
                break;
            case R.id.tv_message_remind:
                //消息提醒
                startMessageRemind();
                break;
            case R.id.tv_edit_password:
                //修改密码
                startEditPassword();
                break;
            case R.id.tv_cancel_user:
                //注销账户
                startCancelUser();
                break;
        }
    }

    /**
     * 注销账户
     */
    private void startCancelUser() {

    }


    /**
     * 跳转到修改密码
     */
    private void startEditPassword() {

    }

    /**
     * 跳转到消息提醒
     */
    private void startMessageRemind() {

    }

    /**
     * 跳转到商家设置
     */
    private void startBusinessSetting() {

    }

    /**
     * 跳转到商家资料
     */
    private void startMechantInfo() {
        jump2Activity(MerchantInfoActivity.class);
    }


}
