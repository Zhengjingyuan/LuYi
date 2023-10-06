package com.example.luyi.parent.memory.model.redata

import com.example.luyi.parent.diary.model.redata.DiaryReData
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData
import com.example.luyi.parent.memory.model.entity.Memory
import com.squareup.moshi.Json

data class MemoryReData(
    @Json(name = "diary_axis")
    val diaryAxis: List<DiaryReData>,

    @Json(name = "memory _axis")
    val memoryAxis: List<Memory>,

    @Json(name = "todo_axis")
    val todoAxis: List<MemorandumReData>
)
