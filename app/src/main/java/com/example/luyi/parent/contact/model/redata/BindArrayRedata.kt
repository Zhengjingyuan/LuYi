package com.example.luyi.parent.contact.model.redata

data class BindArrayRedata (
    /**
     * 身份，0为父母1为子女
     */
    val identity: Long,

    /**
     * 昵称，昵称
     */
    val nickname: String,

    /**
     * 手机号，手机号
     */
    val phone: String,

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