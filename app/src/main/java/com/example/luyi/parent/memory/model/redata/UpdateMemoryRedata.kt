package com.example.luyi.parent.memory.model.redata

import com.example.luyi.parent.diary.model.entity.DiaryImage

data class UpdateMemoryRedata(
    /**
     * 回忆发生的时间
     */
    val datetime: String,

    /**
     * 事件描述
     */
    val detail: String,

    val images: List<DiaryImage>,

    /**
     * 插入事件id
     */
    val meid: Long,

    /**
     * 父母id
     */
    val pid: Long,

    /**
     * 插入者头像
     */
    val profile: String,

    /**
     * 插入者id
     */
    val uid: Long
)
