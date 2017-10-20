package com.pujitech.wxgcommonhttp.modules.message.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.message.module.MessageModule;
import com.pujitech.wxgcommonhttp.modules.message.view.MessageView;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class MessagePresenter extends BasePresenter<MessageView,MessageModule> {


    public MessagePresenter(Context context) {
        super(context);
    }

    @Override
    protected MessageModule initModule() {
        return new MessageModule();
    }
}
