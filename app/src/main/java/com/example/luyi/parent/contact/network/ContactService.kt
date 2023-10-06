package com.example.luyi.parent.contact.network

import com.example.luyi.NetWorkWithToken
import com.example.luyi.parent.contact.model.entity.AddAddressRequest
import com.example.luyi.parent.contact.model.entity.AddAddressResponse
import com.example.luyi.parent.contact.model.entity.AddDetailResponse
import com.example.luyi.parent.contact.model.entity.AddressListResponse
import com.example.luyi.parent.contact.model.entity.BindDetailResponse
import com.example.luyi.parent.contact.model.entity.TimeLineRequest
import com.example.luyi.parent.contact.model.entity.TimeLineResponse
import com.example.luyi.parent.contact.model.entity.UpdateAddressReponse
import com.example.luyi.parent.contact.model.entity.UpdateAddressRequest
import com.example.luyi.parent.contact.model.redata.AddDetailRedata
import com.example.luyi.parent.diary.model.entity.AddDiaryResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field

import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import java.io.File

interface ContactService {

    @GET("addresslist")
    suspend fun getAddress():AddressListResponse

    @GET("addresslist/addinfo/{aid}")
    suspend fun getAddDtail(@Path("aid")aid:String):AddDetailResponse

    @GET("addresslist/bindinfo/{bid}")
    suspend fun getBindDtail(@Path("bid")bid:String):BindDetailResponse

    @POST("addresslist")
    suspend fun addAddress(@Body request: AddAddressRequest):AddAddressResponse

    @POST("addresslist/addtimeline")
    suspend fun addTimeline(@Body request: TimeLineRequest): TimeLineResponse

    @POST("addresslist/bindtimeline")
    suspend fun bindTimeline(@Body request: TimeLineRequest): TimeLineResponse

    @PATCH("addresslist")
    suspend fun updataAddress(@Body request: UpdateAddressRequest): UpdateAddressReponse

    @DELETE("addresslist")
    suspend fun deletAddress(@Body aid:Long):AddDetailResponse

    @POST("addresslist/profile")
    suspend fun postProfile(
        @Field("aid")aid:String,
        @Field("profile")profile:File
    ):UpdateAddressReponse

    @PATCH("addresslist/profile")
    suspend fun updateProfile(
        @Field("aid")aid:String,
        @Field("profile")profile:File
    ):UpdateAddressReponse

    @DELETE("addresslist/addtimeline")
    suspend fun deletAddAddress(@Body adrtlid:Long):TimeLineResponse

    @DELETE("addresslist/bindtimeline")
    suspend fun deletBindAddress(@Body adrtlid:Long):TimeLineResponse

    @PATCH("addresslist/addtimeline")
    suspend fun upAddTimeline(@Body request: TimeLineRequest): TimeLineResponse

    @PATCH("addresslist/bindtimeline")
    suspend fun upBindTimeline(@Body request: TimeLineRequest): TimeLineResponse


    companion object{
        fun instance():  ContactService {
            return NetWorkWithToken.createService( ContactService::class.java)
        }
    }
}