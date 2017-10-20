package com.pujitech.wxgcommonhttp.modules.login.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.CommonObserver;
import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.commonhttplibrary.utils.StringUtils;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.modules.login.module.LoginModule;
import com.pujitech.wxgcommonhttp.modules.login.view.LoginView;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public class LoginPresenter extends BasePresenter<LoginView, LoginModule> {


    public LoginPresenter(Context context) {
        super(context);
    }

    @Override
    protected LoginModule initModule() {
        return new LoginModule();
    }


    /**
     * 登录
     *
     * @param userName
     * @param passWord
     */
    public void doLogin(String userName, String passWord) {
        if (StringUtils.isEmpty(userName)) {
            mView.showToast(mContext.getString(R.string.login_username_not_empty));
            return;
        }
        if (StringUtils.isEmpty(passWord)) {
            mView.showToast(mContext.getString(R.string.login_password_not_empty));
            return;
        }

        mView.doLoginSuccess();

        mModule.doLogin(mContext, userName, passWord, new CommonObserver.OnRequestDataListener<String>() {
            @Override
            public void onSuccess(String s) {

            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onCompleted() {

            }
        });


    }


}
