package com.example.luyi.parent.memorandum.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.parent.memorandum.model.entity.AddMemorandumRequest
import com.example.luyi.parent.memorandum.model.entity.AddMemorandumResponse
import com.example.luyi.parent.memorandum.model.entity.ChangeMemorandumRequest
import com.example.luyi.parent.memorandum.model.entity.ChangeMemorandumResponse
import com.example.luyi.parent.memorandum.model.entity.DeletMemorandumResponse
import com.example.luyi.parent.memorandum.model.entity.MemorandumResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface MemorandumService {
    @GET("todo/list")
    suspend fun getMemorandum(): MemorandumResponse

    @POST("todo/add")
    suspend fun addMemorandum(@Body request: AddMemorandumRequest): AddMemorandumResponse

    @DELETE("todo/delete")
    suspend fun deletMemorandum(@Body tid:Long): DeletMemorandumResponse

    @PATCH("todo/update")
    suspend fun updataMemorandum(@Body request: ChangeMemorandumRequest):ChangeMemorandumResponse

    companion object{
        fun instance(): MemorandumService {
            return NetWorkWithToken.createService(MemorandumService::class.java)
        }
    }
}