package com.example.luyi.basic.network.service

import com.example.luyi.basic.model.entity.CaptchaResponse
import com.example.luyi.basic.network.NetWork
import retrofit2.http.POST
import retrofit2.http.Path

interface CaptchaService {
    @POST("captcha/{phone_number}")
    suspend fun sendCaptcha(@Path("phone_number") phoneNumber: String):CaptchaResponse

    companion object{
        fun instance(): CaptchaService {
            return NetWork.createService(CaptchaService::class.java)
        }
    }
}