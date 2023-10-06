package com.example.luyi.parent.callhelp.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.parent.callhelp.model.entity.AddPhoneResponse
import com.example.luyi.parent.callhelp.model.entity.PhoneResponse
import com.example.luyi.parent.diary.network.DiaryService
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface CallHlepService {
    @GET("sos")
    suspend fun getPhone():PhoneResponse

    @POST("sos")
    suspend fun addPhone(@Body phone:String):AddPhoneResponse

    @PATCH("sos")
    suspend fun updatePhone(@Body phone:String):AddPhoneResponse

    companion object{
        fun instance(): CallHlepService {
            return NetWorkWithToken.createService(CallHlepService::class.java)
        }
    }

}