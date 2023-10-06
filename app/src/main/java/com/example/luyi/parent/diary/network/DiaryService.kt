package com.example.luyi.parent.diary.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.parent.diary.model.entity.AddDiaryResponse
import com.example.luyi.parent.diary.model.entity.DeletDiaryResponse
import com.example.luyi.parent.diary.model.entity.DiaryListResponse
import com.example.luyi.parent.diary.model.entity.DiaryResponse
import com.example.luyi.parent.memorandum.model.entity.DeletMemorandumResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.io.File

interface DiaryService {
    @GET("diary/list")
    suspend fun getDiaryList(): DiaryListResponse

    @GET("diary/{did}")
    suspend fun getDiaryDetail(@Path("did") did: String): DiaryResponse

    @DELETE("diary/{did}")
    suspend fun deletDiary(@Path("did") did: String):  DeletDiaryResponse

    @POST("diary/write")
    suspend fun addDiary(
        @Field("title")title:String,
        @Field("text")text:String,
        @Field("image")image:File?=null
    ):AddDiaryResponse

    @PATCH("diary/update")
    suspend fun updateDiary(
        @Field("title")title:String,
        @Field("text")text:String,
        @Field("image")image:File?=null,
        @Field("did")did:String
    ):AddDiaryResponse//返回的数据结构相同

    companion object{
        fun instance(): DiaryService {
            return NetWorkWithToken.createService(DiaryService::class.java)
        }
    }
}