package com.example.luyi.children.mine.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.children.mine.model.redata.BindRedata
import com.squareup.moshi.Json

data class BindRequest(
    /**
     * 身份证号，身份证号
     */
    @Json(name = "id_number")
    val idNumber: String,

    /**
     * 手机号，手机号
     */
    val phone: String,

    /**
     * 真实姓名，真实姓名
     */
    val realname: String,

    /**
     * 用户id，用户id
     */
    val uid: Long,

    /**
     * 用户账号，用户账号
     */
    val username: String
)

data class BindResponse(var data:BindRedata):BaseResponse()
