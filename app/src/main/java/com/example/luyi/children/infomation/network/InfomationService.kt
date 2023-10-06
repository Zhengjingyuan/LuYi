package com.example.luyi.children.infomation.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.children.mine.network.MyService
import com.example.luyi.parent.diary.model.entity.DiaryListResponse
import com.example.luyi.parent.diary.model.entity.DiaryResponse
import com.example.luyi.parent.diary.model.redata.DiaryListReData
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
import retrofit2.http.Path
import java.io.File

interface InfomationService {

    @GET("diary/list/{pid}")
    suspend fun getParentDiary(@Path("pid")pid:String):DiaryListResponse

    @GET("diary/list/{did}")
    suspend fun getParentDiaryDetail(@Path("did")did:String):DiaryResponse

    @GET("memory/{pid}")
    suspend fun getParentMemory(@Path("pid")pid:String):MemoryResponse

    @POST("memory/upload")
    suspend fun addMemory(
        @Field("data")data: File?=null,
        @Field("pid")pid:Long,
        @Field("datetime")datetime:String,
        @Field("detail")detail:String
    ): AddMemoryResponse

    @DELETE("memory/delete")
    suspend fun deletParentMemory(@Body meid:Long): DeletMemoryResponse

    companion object{
        fun instance(): InfomationService {
            return NetWorkWithToken.createService( InfomationService::class.java)
        }
    }

    @PATCH("memory/update")
    suspend fun updateParentMemory(
        @Field("data")data:File?=null,
        @Field("pid")pid:Long,
        @Field("datetime")datetime:String,
        @Field("detail")detail:String,
        @Field("meid")meid:Int
    ): UpdateResponse
}