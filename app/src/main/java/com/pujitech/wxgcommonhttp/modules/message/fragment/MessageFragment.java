package com.pujitech.wxgcommonhttp.modules.message.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.modules.message.presenter.MessagePresenter;
import com.pujitech.wxgcommonhttp.modules.message.view.MessageView;

import butterknife.ButterKnife;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class MessageFragment extends BaseFragment<MessagePresenter> implements MessageView {
    @Override
    protected void initData() {

    }

    @Override
    protected View inflateView() {
        return LayoutInflater.from(mContext).inflate(R.layout.fragment_message, null);
    }

    @Override
    protected MessagePresenter createPresenter(Context context) {
        return new MessagePresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
        ButterKnife.bind(this, mRootView);
    }
}
