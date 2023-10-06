package com.example.luyi.parent.memorandum.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

data class AddMemorandumRequest(
    /**
     * 是否完成
     */
    val done: Boolean,

    /**
     * 代办内容
     */
    val todo: String
)

data class AddMemorandumResponse(var data: List<MemorandumReData>? = null): BaseResponse()
