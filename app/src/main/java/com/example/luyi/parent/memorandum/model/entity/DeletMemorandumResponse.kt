package com.example.luyi.parent.memorandum.model.entity

import com.example.luyi.basic.model.entity.BaseResponse
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

data class DeletMemorandumResponse(var data:List<MemorandumReData>? = null):BaseResponse()
