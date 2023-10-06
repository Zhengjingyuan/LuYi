package com.example.luyi.basic.model.entity

import com.example.luyi.basic.model.redata.RegisterRedata

data class RegisterRequest (
    /**
     * 用户输入的验证码
     */
    val captcha: String,

    /**
     * 身份，0为父母1为子女
     */
    val identity: Long,

    /**
     * 昵称，昵称
     */
    val nickname: String,

    /**
     * 密码，密码
     */
    val password: String,

    /**
     * 手机号，手机号
     */
    val phone: String,

    /**
     * 用户账号，用户账号
     */
    val username: String
)

data class RegisterResponse(var data:RegisterRedata): BaseResponse()