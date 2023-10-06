package com.example.luyi.parent.contact.model.entity

import com.example.luyi.basic.model.entity.BaseResponse

data class TimeLineRequest(
    /**
     * 记录所属通讯录id，与uid不能同时为空
     */
    val aid: Long? = null,

    /**
     * 备注
     */
    val remark: String
)

data class TimeLineResponse(var data:Timeline):BaseResponse()