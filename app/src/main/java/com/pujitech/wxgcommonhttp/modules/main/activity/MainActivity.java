package com.pujitech.wxgcommonhttp.modules.main.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pujitech.commonhttplibrary.RxLifeRecycle;
import com.pujitech.commonhttplibrary.bases.BaseActivity;
import com.pujitech.commonhttplibrary.bases.BaseFragment;
import com.pujitech.commonhttplibrary.utils.DialogUtils;
import com.pujitech.wxgcommonhttp.R;
import com.pujitech.wxgcommonhttp.R2;
import com.pujitech.wxgcommonhttp.modules.main.presenter.MainPresenter;
import com.pujitech.wxgcommonhttp.modules.message.fragment.MessageFragment;
import com.pujitech.wxgcommonhttp.modules.orders.home.fragment.OrderFragment;
import com.pujitech.wxgcommonhttp.modules.product.fragment.ProductFragment;
import com.pujitech.wxgcommonhttp.modules.setting.home.fragment.SettingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements RxLifeRecycle, View.OnClickListener, AdapterView.OnItemClickListener {

    @BindView(R2.id.fl_fragment)
    FrameLayout fl_fragment;                //填充fragment的FrameLayout

    @BindView(R2.id.rl_orders_bg)
    RelativeLayout rl_orders_bg;            //订单按钮

    @BindView(R2.id.rl_product_bg)
    RelativeLayout rl_product_bg;           //产品按钮

    @BindView(R2.id.rl_message_bg)
    RelativeLayout rl_message_bg;           //消息按钮

    @BindView(R2.id.rl_setting_bg)
    RelativeLayout rl_setting_bg;           //设置按钮

    @BindView(R2.id.iv_orders)
    ImageView iv_orders;
    @BindView(R2.id.tv_orders)
    TextView tv_orders;
    @BindView(R2.id.iv_product)
    ImageView iv_product;
    @BindView(R2.id.tv_product)
    TextView tv_product;
    @BindView(R2.id.iv_messages)
    ImageView iv_messages;
    @BindView(R2.id.tv_message)
    TextView tv_message;
    @BindView(R2.id.iv_setting)
    ImageView iv_setting;
    @BindView(R2.id.tv_setting)
    TextView tv_setting;


    @BindView(R2.id.iv_back)
    View iv_back;

    @BindView(R2.id.tv_title)
    TextView tv_title;                          //页面的title

    @BindView(R2.id.tv_right_text)
    TextView tv_right_text;                     //顶部状态栏右侧文字

    private int mCheckedPosition = -1;
    private OrderFragment mOrderFragment;       //订单模块对应的页面
    private ProductFragment mProductFragment;   //产品模块对应的页面
    private MessageFragment mMessageFragment;   //消息模块对应的页面
    private SettingFragment mSettingFragment;   //设置模块对应的页面

    private String[] mArrays = {"商品订单", "服务订单", "课程培训", "场地预约"};
    private ListPopupWindow mTopListPopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化界面
     */
    private void initView() {
        mDoubleClickExit = true;
        tv_right_text.setText(mArrays[0]);

        switchButtonChecked(0);

        initOrderFragmentData();
    }

    /**
     * 初始化订单模块页面的数据
     */
    private void initOrderFragmentData() {
        if (mOrderFragment != null) {
            mOrderFragment.initArrayData(mArrays);
            mOrderFragment.showFragmentPosition(0);
        }
    }


    /**
     * 切换按钮
     *
     * @param position
     */
    private void switchButtonChecked(int position) {
        if (position == mCheckedPosition) {
            return;
        }
        mCheckedPosition = position;
        switch (position) {
            case 0:
                //选中订单模块
                if (mOrderFragment == null) {
                    mOrderFragment = BaseFragment.createFragment(OrderFragment.class);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, mOrderFragment).commit();
                }
                break;
            case 1:
                //选中产品模块
                if (mProductFragment == null) {
                    mProductFragment = BaseFragment.createFragment(ProductFragment.class);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, mProductFragment).commit();
                }
                break;
            case 2:
                //选中消息模块
                if (mMessageFragment == null) {
                    mMessageFragment = BaseFragment.createFragment(MessageFragment.class);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, mMessageFragment).commit();
                }
                break;
            case 3:
                //选中设置模块
                if (mSettingFragment == null) {
                    mSettingFragment = BaseFragment.createFragment(SettingFragment.class);
                    getSupportFragmentManager().beginTransaction().add(R.id.fl_fragment, mSettingFragment).commit();
                }
                break;
        }

        hideAllFragment(position);

        updataBottomAndTitle(position);

    }

    /**
     * 按照指定位置更新title以及底部bottom的显示
     *
     * @param position
     */
    private void updataBottomAndTitle(int position) {
        switch (position) {
            case 0:
                //订单管理
                tv_title.setText(getString(R.string.orders_top_title));
                iv_back.setVisibility(View.VISIBLE);

                break;
            case 1:
                //产品管理
                tv_title.setText(getString(R.string.product_top_title));
                break;
            case 2:
                //消息管理
                tv_title.setText(getString(R.string.message_top_title));
                break;
            case 3:
                //设置页面
                tv_title.setText(getString(R.string.setting_top_title));


                break;
        }


    }

    /**
     * 隐藏所有fragment,并按指定位置显示fragment
     */
    private void hideAllFragment(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (mOrderFragment != null) {
            transaction.hide(mOrderFragment);
        }
        if (mProductFragment != null) {
            transaction.hide(mProductFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }
        if (mSettingFragment != null) {
            transaction.hide(mSettingFragment);
        }
        switch (position) {
            case 0:
                if (mOrderFragment != null) {
                    transaction.show(mOrderFragment);
                    tv_right_text.setVisibility(View.VISIBLE);
                }
                break;
            case 1:
                if (mProductFragment != null) {
                    transaction.show(mProductFragment);
                    tv_right_text.setVisibility(View.GONE);
                }
                break;
            case 2:
                if (mMessageFragment != null) {
                    transaction.show(mMessageFragment);
                    tv_right_text.setVisibility(View.GONE);
                }
                break;
            case 3:
                if (mSettingFragment != null) {
                    transaction.show(mSettingFragment);
                    tv_right_text.setVisibility(View.GONE);
                }
                break;
        }
        transaction.commit();
    }


    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void attachView() {

    }


    @OnClick({R2.id.rl_orders_bg, R2.id.rl_product_bg, R2.id.rl_message_bg, R2.id.rl_setting_bg, R2.id.tv_right_text})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_orders_bg:
                switchButtonChecked(0);//订单页面
                break;
            case R.id.rl_product_bg:
                switchButtonChecked(1);//产品页面
                break;
            case R.id.rl_message_bg:
                switchButtonChecked(2);//消息页面
                break;
            case R.id.rl_setting_bg:
                switchButtonChecked(3);//设置页面
                break;
            case R.id.tv_right_text:
                //顶部悬浮窗
                showTopPopup();
                break;
        }
    }

    /**
     * 显示顶部标题栏右侧悬浮窗
     */
    private void showTopPopup() {
        if (mTopListPopup == null) {
            mTopListPopup = DialogUtils.showPopupWindow(this, tv_right_text, mArrays, this);
        } else if (mTopListPopup.isShowing()) {
            mTopListPopup.dismiss();
        } else {
            mTopListPopup.show();
        }
    }

    /**
     * 顶部popupWindow的item点击事件
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (mArrays[position].equals(tv_right_text.getText().toString())) {
            //和上次选中项相同
            return;
        }
        tv_right_text.setText(mArrays[position]);
        //显示指定位置的fragment
        mOrderFragment.showFragmentPosition(position);
    }
}
