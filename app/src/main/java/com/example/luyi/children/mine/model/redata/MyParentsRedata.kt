package com.example.luyi.children.mine.model.redata

import com.squareup.moshi.Json

data class MyParentsRedata(
    /**
     * 绑定电话号码
     */
    val bindphone: String? = null,

    /**
     * 身份证号，身份证号
     */
    @Json(name = "id_number")
    val idNumber: String,

    /**
     * 昵称，昵称
     */
    val nickname: String,

    /**
     * 头像，头像图片
     */
    val profile: String,

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
