package com.example.luyi.basic.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.luyi.basic.model.entity.ForgetPasswordRequest
import com.example.luyi.basic.network.service.ForgetService

class ForgetViewModel:ViewModel() {

    private val forgetService=ForgetService.instance()

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var captcha by mutableStateOf("")

    suspend fun forget(){
        val forget_user=ForgetPasswordRequest(captcha,password,username)
        val res=forgetService.forget(forget_user)
        if (res.data!=null){

        }else{

        }
    }
}
