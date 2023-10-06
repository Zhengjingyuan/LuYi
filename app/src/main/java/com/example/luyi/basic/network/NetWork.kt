package com.example.luyi.basic.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetWork {
    private const val baseUrl="https://mock.apifox.cn/m1/3338955-0-default"


    private val retrofit= Retrofit.Builder()
        .baseUrl(baseUrl)
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