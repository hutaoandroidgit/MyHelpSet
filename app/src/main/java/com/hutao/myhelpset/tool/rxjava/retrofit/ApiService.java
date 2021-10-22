package com.hutao.myhelpset.tool.rxjava.retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * retrofit注解接口写法
 * @author: hutao
 * @date: 2021/10/13
 */
public interface ApiService {
    @GET("mytest/getUserInfo")
    Observable<UserInfo> getUserInfo(@Query("username") String username,@Query("password") String password);

    @GET("mytest/getVipInfo")
    Observable<VipInfo> getVipInfo(@Query("uid") String uid);
}


