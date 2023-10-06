package com.example.luyi.parent.contact.model.redata

data class AddAddressRedata(
    /**
     * id
     */
    val aid: Long,

    /**
     * 联系人昵称
     */
    val nickname: String? = null,

    /**
     * 联系人电话号码
     */
    val phone: String,

    /**
     * 联系人头像
     */
    val profile: String? = null,

    /**
     * 联系人真实姓名
     */
    val realname: String,

    /**
     * 通讯录所属用户id
     */
    val uid: Long
)
