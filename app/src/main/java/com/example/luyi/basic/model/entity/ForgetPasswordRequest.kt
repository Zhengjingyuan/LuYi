package com.example.luyi.basic.model.entity

import com.example.luyi.basic.model.redata.ForgetReData

data class ForgetPasswordRequest (
    /**
     * 用户输入的验证码
     */
    val captcha: String,

    /**
     * 密码，密码
     */
    val password: String,

    /**
     * 用户账号，用户账号
     */
    val username: String
)

data class ForgetResponse(var data: ForgetReData): BaseResponse()

