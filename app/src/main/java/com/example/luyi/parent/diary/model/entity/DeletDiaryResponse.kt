package com.example.luyi.parent.diary.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.squareup.moshi.Json

data class DeletDiaryResponse(
    /**
     * 写日记时间
     */
    val datetime: String,

    @Json(name = "diary_images")
    val diaryImages: List<DiaryImage>,

    /**
     * 日记id
     */
    val did: Long? = null
):BaseResponse()
