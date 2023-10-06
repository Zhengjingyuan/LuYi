package com.example.luyi.basic.network.service

import com.example.luyi.basic.model.entity.LoginRequest
import com.example.luyi.basic.model.entity.LoginResponse
import com.example.luyi.basic.model.entity.RegisterRequest
import com.example.luyi.basic.model.entity.RegisterResponse
import com.example.luyi.basic.network.NetWork
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("user/register")
    suspend fun signUp(@Body request: RegisterRequest): RegisterResponse

    companion object{
        fun instance(): RegisterService {
            return NetWork.createService(RegisterService::class.java)
        }
    }
}