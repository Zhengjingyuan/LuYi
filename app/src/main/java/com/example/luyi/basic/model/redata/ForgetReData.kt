package com.example.luyi.basic.model.redata

data class ForgetReData (
    /**
     * 身份，0为父母1为子女
     */
    val identity: Long,

    /**
     * jwt，jwt
     */
    val token: String,

    /**
     * 用户账号，用户账号
     */
    val username: String
)