package com.pujitech.commonhttplibrary;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by WangXuguang on 2017/9/26.
 */

public class CommonObserver<T extends Object> implements Observer<T> {

    private OnRequestDataListener onRequestDataListener;
    private Disposable mDisposable;

    /**
     * 注册到Observer中的对象，用来解除联网操作
     *
     * @param
     * @param onRequestDataListener
     */
    public CommonObserver(RxLifeRecycle v, OnRequestDataListener onRequestDataListener) {
        if (v != null) {
            v.setRegisterObject(this);
        }
        this.onRequestDataListener = onRequestDataListener;
    }


    @Override
    public void onSubscribe(@NonNull Disposable d) {
        mDisposable = d;
    }

    @Override
    public void onNext(@NonNull T t) {
        if (onRequestDataListener != null) {
            onRequestDataListener.onSuccess(t);
        }

    }

    @Override
    public void onError(@NonNull Throwable e) {
        if (onRequestDataListener != null) {
            onRequestDataListener.onError(e.getMessage());
        }

    }

    @Override
    public void onComplete() {
        if (onRequestDataListener != null) {
            onRequestDataListener.onCompleted();
        }
    }

    /**
     * 取消网络请求
     */
    public void onDestroy() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }


    public interface OnRequestDataListener<T> {

        void onSuccess(T t);

        void onError(String error);

        void onCompleted();

    }

}
