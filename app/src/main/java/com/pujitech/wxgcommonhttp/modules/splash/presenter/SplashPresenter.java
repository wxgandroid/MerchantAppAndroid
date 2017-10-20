package com.pujitech.wxgcommonhttp.modules.splash.presenter;

import android.content.Context;

import com.pujitech.commonhttplibrary.bases.BasePresenter;
import com.pujitech.wxgcommonhttp.modules.splash.module.SplashModule;
import com.pujitech.wxgcommonhttp.modules.splash.view.SplashView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public class SplashPresenter extends BasePresenter<SplashView, SplashModule> {

    private long mTimes = 3;

    private boolean mIsInterrupt;

    private Disposable mDisposable;

    public SplashPresenter(Context context) {
        super(context);
    }

    @Override
    protected SplashModule initModule() {
        return new SplashModule();
    }


    /**
     * 加载倒计时的信息
     */
    public void loadTimeCount() {

        mView.refreshTimeCountView(mTimes);

        Observable.interval(1, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        mTimes--;
                        if (mIsInterrupt) {
                            mDisposable.dispose();
                        }
                        if (mTimes >= 0) {
                            mView.refreshTimeCountView(mTimes);
                        } else {
                            mDisposable.dispose();
                            mView.jump2LoginActivity();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mDisposable = null;
                    }
                });

    }


    /**
     * 打断当前读数
     */
    public void interruptCount(boolean isExit) {
        mIsInterrupt = true;
        if (!isExit) {
            mView.jump2LoginActivity();
        }

    }
}
