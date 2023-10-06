package com.example.luyi.parent.memory.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.parent.diary.network.DiaryService
import com.example.luyi.parent.memory.model.entity.AddMemoryResponse
import com.example.luyi.parent.memory.model.entity.DeletMemoryRequest
import com.example.luyi.parent.memory.model.entity.DeletMemoryResponse
import com.example.luyi.parent.memory.model.entity.MemoryResponse
import com.example.luyi.parent.memory.model.entity.UpdateResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import java.io.File

interface MemoryService {

    @GET("memory")
    suspend fun getMemory():MemoryResponse

    @POST("memory/upload")
    suspend fun addMemory(
        @Field ("data")data:File?=null,
        @Field("pid")pid:Long,
        @Field("datetime")datetime:String,
        @Field("detail")detail:String
    ):AddMemoryResponse

    @DELETE("memory/delete")
    suspend fun deletMemory(@Body meid:Long):DeletMemoryResponse

    @PATCH("memory/update")
    suspend fun updateMemory(
        @Field("data")data:File?=null,
        @Field("pid")pid:Long,
        @Field("datetime")datetime:String,
        @Field("detail")detail:String,
        @Field("meid")meid:Int
    ):UpdateResponse


    companion object{
        fun instance(): MemoryService {
            return NetWorkWithToken.createService(MemoryService::class.java)
        }
    }
}