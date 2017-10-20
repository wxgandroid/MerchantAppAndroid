package com.pujitech.commonhttplibrary.bases;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by WangXuguang on 2017/9/22.
 */

public interface BaseHttpApi {


    /**
     * Get请求数据
     *
     * @param interfaceName
     * @param fieldMap
     * @return
     */
    @GET
    Observable<String> getCommonData(@Url String interfaceName, @QueryMap Map<String, Object> fieldMap);

    /**
     * Post请求数据(表单请求)
     *
     * @param interfaceName
     * @param fieldMap
     * @return
     */
    @FormUrlEncoded
    @POST
    Observable<String> postCommonData(@Url String interfaceName, @FieldMap Map<String, Object> fieldMap);

}
