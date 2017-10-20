package com.pujitech.wxgcommonhttp.modules.login.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pujitech.commonhttplibrary.bases.BaseActivity;
import com.pujitech.wxgcommonhttp.modules.main.activity.MainActivity;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.login.presenter.LoginPresenter;
import com.pujitech.wxgcommonhttp.modules.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView, View.OnClickListener {
    @BindView(R2.id.tv_title)
    TextView tv_title;
    @BindView(R2.id.iv_back)
    View iv_back;
    @BindView(R2.id.et_user_name)
    EditText et_user_name;
    @BindView(R2.id.et_user_pwd)
    EditText et_user_pwd;
    @BindView(R2.id.btn_login)
    Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //初始化ui
        initView();

    }

    /**
     * 初始化ui
     */
    private void initView() {
        tv_title.setText(getString(R.string.login_title));
        iv_back.setVisibility(View.GONE);
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }


    @OnClick(R.id.btn_login)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                //登录按钮
                mPresenter.doLogin(et_user_name.getText().toString(), et_user_pwd.getText().toString());
                break;
        }
    }

    /**
     * 用户登录成功
     */
    @Override
    public void doLoginSuccess() {
        jump2Activity(MainActivity.class);
    }
}
