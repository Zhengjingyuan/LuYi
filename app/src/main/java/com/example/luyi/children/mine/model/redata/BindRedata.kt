package com.example.luyi.children.mine.model.redata

data class BindRedata(
    /**
     * 绑定电话号码
     */
    val bindphone: String? = null,

    /**
     * 身份，0为父母1为子女
     */
    val identity: Long,

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
