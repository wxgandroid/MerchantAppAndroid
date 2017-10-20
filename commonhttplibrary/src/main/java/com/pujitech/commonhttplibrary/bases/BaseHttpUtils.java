package com.pujitech.commonhttplibrary.bases;

import com.pujitech.commonhttplibrary.CommonObserver;
import com.pujitech.commonhttplibrary.RetrofitUtils;
import com.pujitech.commonhttplibrary.RxLifeRecycle;
import com.pujitech.commonhttplibrary.RxSchedulers;
import com.pujitech.commonhttplibrary.utils.StringUtils;

import java.util.Map;

/**
 * Created by WangXuguang on 2017/9/20.
 */

public class BaseHttpUtils {

    private static BaseHttpUtils mInstance; //HttpUtils单例处理

    private String BASE_URL; //网络请求的baseUrl


    private BaseHttpUtils() {

    }


    /**
     * 获取当前对象
     *
     * @return
     */
    public static BaseHttpUtils getInstance() {
        synchronized (mInstance) {
            if (mInstance == null) {
                mInstance = new BaseHttpUtils();
            }
        }
        return mInstance;
    }


    /**
     * GET请求获取数据(String类型返回值)
     */
    public void getCommonData(RxLifeRecycle context, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener<String> onRequestDataListener) {
        if (StringUtils.isEmpty(BASE_URL)) {
            throw new RuntimeException("BaseUrl不能为空");
        }
        getDataFromNet(context, BaseHttpApi.class, BASE_URL, interfaceName, map, onRequestDataListener);
    }

    /**
     * POST请求获取数据（String类型返回值）
     */
    public void postCommonData(RxLifeRecycle context, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener<String> onRequestDataListener) {
        if (StringUtils.isEmpty(BASE_URL)) {
            throw new RuntimeException("BaseUrl不能为空");
        }
        postDataFromNet(context, BaseHttpApi.class, BASE_URL, interfaceName, map, onRequestDataListener);
    }


    /**
     * 根据临时的url获取网络数据
     *
     * @param tempUrl
     * @param interfaceName
     * @param map
     * @param onRequestDataListener
     */
    public void getTempUrlCommonData(RxLifeRecycle context, String tempUrl, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener<String> onRequestDataListener) {
        getDataFromNet(context, BaseHttpApi.class, tempUrl, interfaceName, map, onRequestDataListener);
    }

    /**
     * 根据临时的url发送post请求得到数据
     *
     * @param context
     * @param tempUrl
     * @param interfaceName
     * @param map
     * @param onRequestDataListener
     */
    public void postTempUrlCommonData(RxLifeRecycle context, String tempUrl, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener<String> onRequestDataListener) {
        postDataFromNet(context, BaseHttpApi.class, tempUrl, interfaceName, map, onRequestDataListener);
    }


    /**
     * 网络请求的BaseUrl
     *
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    /**
     * 设置网络请求的临时url
     *
     * @param tempUrl
     */
    public BaseHttpApi setTempUrl(String tempUrl) {
        return RetrofitUtils.getInstance(BaseHttpApi.class, tempUrl);
    }

    /**
     * 根据传递的参数，返回一个Service.class的对象
     *
     * @param t
     * @param baseUrl
     * @param <T>
     * @return
     */
    public <T extends Object> T getHttpApiService(Class<T> t, String baseUrl) {
        return RetrofitUtils.getInstance(t, baseUrl);
    }

    /**
     * 获取网络数据
     *
     * @param rxLifeRecycle
     * @param commonHttpServiceClass
     * @param url
     * @return
     */
    private void getDataFromNet(RxLifeRecycle rxLifeRecycle, Class<BaseHttpApi> commonHttpServiceClass, String url, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener onRequestDataListener) {
        CommonObserver<String> observer = new CommonObserver<>(rxLifeRecycle, onRequestDataListener);
        RetrofitUtils.getInstance(commonHttpServiceClass, url)
                .getCommonData(interfaceName, map)
                .compose(RxSchedulers.<String>compose())
                .subscribe(observer);
    }

    /**
     * POST请求获取联网数据
     *
     * @param context
     * @param baseHttpApiClass
     * @param base_url
     * @param interfaceName
     * @param map
     * @param onRequestDataListener
     */
    private void postDataFromNet(RxLifeRecycle context, Class<BaseHttpApi> baseHttpApiClass, String base_url, String interfaceName, Map<String, Object> map, CommonObserver.OnRequestDataListener<String> onRequestDataListener) {
        RetrofitUtils.getInstance(baseHttpApiClass, base_url)
                .postCommonData(interfaceName, map)
                .compose(RxSchedulers.<String>compose())
                .subscribe(new CommonObserver<String>(context, onRequestDataListener));
    }


    public BaseHttpUtils setConnectOutTime(long connectOutTime) {
        RetrofitUtils.setTimeOut(connectOutTime);
        return this;
    }


}
