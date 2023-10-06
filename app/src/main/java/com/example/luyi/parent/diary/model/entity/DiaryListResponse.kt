package com.example.luyi.parent.diary.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.diary.model.redata.DiaryListReData

data class DiaryListResponse(val data: List<DiaryListReData>? = null):BaseResponse()
