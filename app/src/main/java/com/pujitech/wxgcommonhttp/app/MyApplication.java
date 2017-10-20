package com.pujitech.wxgcommonhttp.app;

import android.app.Application;

import com.pujitech.commonhttplibrary.bases.BaseActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WangXuguang on 2017/10/18.
 */

public class MyApplication extends Application {


    private static MyApplication instance;

    private List<BaseActivity> mActivityStacks;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mActivityStacks = new ArrayList<>();
    }

    /**
     * 返回当前的application对象
     *
     * @return
     */
    public static MyApplication getApplication() {
        return instance;
    }

    /**
     * 将activity添加到集合中
     *
     * @param activity
     */
    public void addActivity2Stack(BaseActivity activity) {
        mActivityStacks.add(activity);
    }

    /**
     * 移除所有的activity
     */
    public void removeActivities() {
        Iterator<BaseActivity> iter = mActivityStacks.iterator();
        while (iter.hasNext()) {
            BaseActivity next = iter.next();
            next.onDestroy();
            iter.remove();
        }
    }



}
