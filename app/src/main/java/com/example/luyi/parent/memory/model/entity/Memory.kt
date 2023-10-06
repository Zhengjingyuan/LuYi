package com.example.luyi.parent.memory.model.entity

import com.example.luyi.parent.diary.model.entity.DiaryImage
import com.squareup.moshi.Json

data class Memory(
    val datetime: String? = null,
    val detail: String? = null,
    val meid: Long? = null,

    @Json(name = "memory_images")
    val memoryImages: List<DiaryImage>? = null,

    val pid: Long? = null,
    val profile: String? = null,
    val uid: Long? = null
)
