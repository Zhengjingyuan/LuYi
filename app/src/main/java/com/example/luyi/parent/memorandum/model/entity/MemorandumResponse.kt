package com.example.luyi.parent.memorandum.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

data class MemorandumResponse (val data: List<MemorandumReData>? = null): BaseResponse()