package com.example.luyi.parent.diary.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.squareup.moshi.Json

data class AddDiaryResponse(
    /**
     * 写日记时间
     */
    val datetime: String,

    @Json(name = "diary_images")
    val diaryImages: List<DiaryImage>,

    /**
     * 日记id
     */
    val did: Long? = null,

    /**
     * 日记标题
     */
    val title: String
):BaseResponse()
