package com.example.luyi.parent.memorandum.model.redata

import com.squareup.moshi.Json

data class MemorandumReData(
    val createAt: String,
    val done: Boolean,
    val tid: Long,
    val title: String,
    val todo: String,
    val uid: Long
)
