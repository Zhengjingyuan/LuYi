package com.example.luyi.parent.contact.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.contact.model.redata.AddAddressRedata

data class AddAddressRequest (
    /**
     * 联系人昵称
     */
    val nickname: String? = null,

    /**
     * 联系人电话号码
     */
    val phone: String,

    /**
     * 联系人真实姓名
     */
    val realname: String
)

data class AddAddressResponse(var data:AddAddressRedata):BaseResponse()