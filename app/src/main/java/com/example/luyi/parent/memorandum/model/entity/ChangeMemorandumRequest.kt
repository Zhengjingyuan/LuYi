package com.example.luyi.parent.memorandum.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

data class ChangeMemorandumRequest(
    /**
     * 是否完成
     */
    val done: Boolean,

    /**
     * 代办id
     */
    val tid: Long
)

data class  ChangeMemorandumResponse(var data:List<MemorandumReData>? = null):BaseResponse()
