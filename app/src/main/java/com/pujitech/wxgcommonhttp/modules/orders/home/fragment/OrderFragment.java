package com.pujitech.wxgcommonhttp.modules.orders.home.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.orders.goodsorder.fragment.GoodsOrderFragment;
import com.pujitech.wxgcommonhttp.modules.orders.home.presenter.OrderPresenter;
import com.pujitech.wxgcommonhttp.modules.orders.home.view.OrderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WangXuguang on 2017/10/19.
 */

public class OrderFragment extends BaseFragment<OrderPresenter> implements OrderView {

    @BindView(R2.id.fl_order_fragment)
    FrameLayout fl_order_fragment;

    private List<GoodsOrderFragment> mFragments = new ArrayList<>();

    private int mCheckPosition = -1;

    private String[] str = {"商品订单", "服务订单", "课程培训", "场地预约"};


    @Override
    protected void initData() {
        mFragments.clear();
        GoodsOrderFragment goodsOrderFragment = null;
        Bundle bundle = null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < str.length; i++) {
            goodsOrderFragment = BaseFragment.createFragment(GoodsOrderFragment.class);
            mFragments.add(goodsOrderFragment);
            transaction.add(R.id.fl_order_fragment, goodsOrderFragment);
        }
        transaction.commit();
        hideAllFragment(0);
    }

    @Override
    protected View inflateView() {
        return LayoutInflater.from(mContext).inflate(R.layout.fragment_order, null);
    }

    @Override
    protected OrderPresenter createPresenter(Context context) {
        return new OrderPresenter(mContext);
    }

    @Override
    protected void attachView() {
        ButterKnife.bind(this, mRootView);
        mPresenter.attachView(this);
    }

    /**
     * 隐藏除了指定目标位置的fragment
     *
     * @param position
     */
    private void hideAllFragment(int position) {
        if (position == mCheckPosition) {
            return;
        }
        mCheckPosition = position;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            if (position == i) {
                transaction.show(mFragments.get(i));
                mFragments.get(i).setOrderType(i);
            } else {
                transaction.hide(mFragments.get(i));
            }
        }
        transaction.commit();
    }


}
