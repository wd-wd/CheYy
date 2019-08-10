package com.lanxiang.cheyy

import com.lanxiang.mvvm.http.response.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 *
 * @Author: wangdong
 * @Date: 2019/8/7-16:40
 *
 * @desc:
 */
interface ApiService {
    @GET("competitionFieldOrder/getAlbumTimes")
    fun getMainData(@QueryMap map: Map<String,String>):Observable<BaseResponse<MainBean>>
}