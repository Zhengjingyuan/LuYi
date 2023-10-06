package com.example.luyi.basic.network.service

import com.example.luyi.basic.model.entity.ForgetPasswordRequest
import com.example.luyi.basic.model.entity.ForgetResponse
import com.example.luyi.basic.model.entity.LoginRequest
import com.example.luyi.basic.model.entity.LoginResponse
import com.example.luyi.basic.network.NetWork
import retrofit2.http.Body
import retrofit2.http.POST

interface ForgetService
{
    @POST("user")
    suspend fun forget(@Body request: ForgetPasswordRequest): ForgetResponse

    companion object{
        fun instance(): ForgetService {
            return NetWork.createService(ForgetService::class.java)
        }
}
}