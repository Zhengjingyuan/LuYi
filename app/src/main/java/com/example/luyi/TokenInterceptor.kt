package com.example.luyi

import com.example.luyi.basic.model.datastoremanager.UserInfoManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class TokenIntercepter(private val userInfoManager: UserInfoManager) :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val token= runBlocking {
            userInfoManager.getToken()
        }
        val request=chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}