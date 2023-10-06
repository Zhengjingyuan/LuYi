package com.example.luyi.basic.model.redata

import android.provider.ContactsContract

data class MyInfoReData (
    val blocked: Boolean,
    val identity: ContactsContract.CommonDataKinds.Identity,
    val idNumber: String? = null,
    val nickname: String,
    val password: String,
    val phone: String,
    val profile: String,
    val realname: String? = null,
    val registerTime: String,
    val uid: Long,
    val username: String
)