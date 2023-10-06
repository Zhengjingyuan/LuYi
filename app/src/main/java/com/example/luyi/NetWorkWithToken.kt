package com.example.luyi

import com.example.luyi.basic.model.datastoremanager.UserInfoManager
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetWorkWithToken {
    private const val baseUrl="https://mock.apifox.cn/m1/3338955-0-default"



    lateinit var userInfoManager: UserInfoManager



    val httpClient=OkHttpClient.Builder()
        .addInterceptor(TokenIntercepter(userInfoManager))
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()

    fun <T>createService(clazz: Class<T>):T{
        return retrofit.create(clazz)
    }
}