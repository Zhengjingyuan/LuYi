package com.example.luyi.parent.memory.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.diary.model.entity.DiaryImage

data class DeletMemoryRequest(
    val images: List<DiaryImage>?=null,

    /**
     * 插入事件id
     */
    val meid: Long
)

data class DeletMemoryResponse(var data:DeletMemoryRequest):BaseResponse()
