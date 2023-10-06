package com.example.luyi.parent.diary.model.redata

data class DiaryListReData(
    /**
     * 写日记时间
     */
    val datetime: String,

    /**
     * 日记id
     */
    val did: Long? = null,

    /**
     * 日记标题
     */
    val title: String
)
