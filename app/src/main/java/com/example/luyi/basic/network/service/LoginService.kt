package com.example.luyi.basic.network.service

import com.example.luyi.basic.model.entity.LoginRequest
import com.example.luyi.basic.model.entity.LoginResponse
import com.example.luyi.basic.network.NetWork
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("user/login")
    suspend fun signIn(@Body request: LoginRequest):LoginResponse

    companion object{
        fun instance(): LoginService {
            return NetWork.createService(LoginService::class.java)
        }
    }


}