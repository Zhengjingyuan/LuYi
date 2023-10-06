package com.example.luyi.parent.diary.model.redata

import com.example.luyi.parent.diary.model.entity.DiaryImage
import com.squareup.moshi.Json

data class DiaryReData(
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
     * 日记正文
     */
    val text: String,

    /**
     * 日记标题
     */
    val title: String,

    /**
     * 日记所属用户id
     */
    val uid: Long
)
