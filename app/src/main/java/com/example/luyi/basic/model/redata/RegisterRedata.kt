package com.example.luyi.basic.model.redata

data class RegisterRedata(
    /**
     * 身份，0为父母1为子女
     */
    val identity: Long,

    /**
     * 手机号，手机号
     */
    val phone: String,

    /**
     * jwt，jwt
     */
    val token: String,

    /**
     * 用户账号，用户账号
     */
    val username: String
)