package com.example.luyi.basic.network.service

import com.example.luyi.basic.model.entity.MyInfoResponse
import com.example.luyi.NetWorkWithToken
import retrofit2.http.GET

interface MyInfoService {
    @GET("user/info")
    suspend fun getMyInfo():MyInfoResponse

    companion object{
        fun instance(): MyInfoService {
            return NetWorkWithToken.createService(MyInfoService::class.java)
        }
    }

}