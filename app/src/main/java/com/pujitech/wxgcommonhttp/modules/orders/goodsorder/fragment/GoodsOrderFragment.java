package com.pujitech.wxgcommonhttp.modules.orders.goodsorder.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.orders.goodsorder.presenter.GoodsOrderPresenter;
import com.pujitech.wxgcommonhttp.modules.orders.goodsorder.view.GoodsOrderView;
import com.pujitech.wxgcommonhttp.weight.TabsView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by WangXuguang on 2017/10/19.
 */

public class GoodsOrderFragment extends BaseFragment<GoodsOrderPresenter> implements GoodsOrderView {

    @BindView(R2.id.tabview_order_goods)
    TabsView tabview_order_goods;

    @BindView(R2.id.vp_order_goods)
    ViewPager vp_order_goods;

    @BindView(R2.id.tv_text)
    TextView tv_text;


    private int mOrderType = -1;   // 0 商品订单   1 服务订单  2 课程培训  3 场地预约

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        return super.onCreateView(inflater, container, bundle);
    }


    @Override
    protected void initData() {
        if (mOrderType == -1) {
            return;
        }
        switch (mOrderType) {
            case 0:
                //商品订单
                tv_text.setText("商品订单");
                break;
            case 1:
                //服务订单
                tv_text.setText("服务订单");
                break;
            case 2:
                //课程培训
                tv_text.setText("课程培训");
                break;
            case 3:
                //场地预约
                tv_text.setText("场地预约");
                break;
        }


    }

    @Override
    protected View inflateView() {
        return LayoutInflater.from(mContext).inflate(R.layout.fragment_order_goods, null);
    }

    @Override
    protected GoodsOrderPresenter createPresenter(Context context) {
        return new GoodsOrderPresenter(mContext);
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
        ButterKnife.bind(this, mRootView);
    }

    /**
     * 设置加载数据的类型,同时加载数据
     */
    public void setOrderType(int orderType) {
        mOrderType = orderType;
    }


}
