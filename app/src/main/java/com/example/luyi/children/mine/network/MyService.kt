package com.example.luyi.children.mine.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.children.mine.model.entity.BindRequest
import com.example.luyi.children.mine.model.entity.BindResponse
import com.example.luyi.children.mine.model.entity.DeletBindResponse
import com.example.luyi.children.mine.model.entity.MyParentsResponse
import com.example.luyi.children.mine.model.redata.DeletBindRedata
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface MyService {

    @GET("parent/info")
    suspend fun getParent():MyParentsResponse

    @POST("bind")
    suspend fun postBind(@Body request: BindRequest):BindResponse

    @DELETE()
    suspend fun deletBind(@Body uid:Long):DeletBindResponse

    companion object{
        fun instance(): MyService {
            return NetWorkWithToken.createService( MyService::class.java)
        }
    }
}