package com.pujitech.wxgcommonhttp.modules.orders.home.fragment;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.commonhttplibrary.utils.LogUtils;
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

    private List<GoodsOrderFragment> mFragments = new ArrayList<>(10);

    private int mCheckPosition = -1;

    private String[] mArrays = null;

    private final String TAG = OrderFragment.class.getSimpleName();

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            LogUtils.i(TAG, "onHiddenChanged");
        }
    }

    @Override
    protected void initData() {
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
    public void showFragmentPosition(int position) {
        if (position == mCheckPosition) {
            return;
        }
        mCheckPosition = position;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        GoodsOrderFragment goodsOrderFragment = mFragments.get(position);
        if (goodsOrderFragment == null) {
            goodsOrderFragment = BaseFragment.createFragment(GoodsOrderFragment.class);
            goodsOrderFragment.setOrderType(position);
            mFragments.add(position, goodsOrderFragment);
        }
        transaction.replace(R.id.fl_order_fragment, goodsOrderFragment).commit();
    }


    /**
     * 初始化数据
     */
    public void initArrayData(String[] arrays) {
        mArrays = arrays;
        mFragments.clear();
        for (int i = 0; i < mArrays.length; i++) {
            mFragments.add(i, null);
        }
    }


}
