package com.example.luyi.parent.callhelp.model.redata

data class AddPhoneReData(
    /**
     * 绑定电话号码
     */
    val bindphone: String? = null,

    /**
     * 身份，0为父母1为子女
     */
    val identity:String,

    /**
     * 用户id，用户id
     */
    val uid: Long
)
