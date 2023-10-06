package com.example.luyi.basic.model.entity

import com.example.luyi.basic.model.redata.LoginReData

data class LoginRequest (
    val username: String,
    val password: String
)

data class LoginResponse(var data:LoginReData): BaseResponse()