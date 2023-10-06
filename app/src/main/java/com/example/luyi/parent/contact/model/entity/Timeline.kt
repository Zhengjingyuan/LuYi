package com.example.luyi.parent.contact.model.entity

data class Timeline (
    /**
     * 记录id
     */
    val adrtlid: Long,

    /**
     * 备注
     */
    val remark: String,

    /**
     * 插入时间/更新时间
     */
    val updateAt: String
)