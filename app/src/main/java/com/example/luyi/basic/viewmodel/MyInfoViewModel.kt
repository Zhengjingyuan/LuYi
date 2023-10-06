package com.example.luyi.basic.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.luyi.basic.model.redata.MyInfoReData
import com.example.luyi.basic.network.service.MyInfoService

class MyInfoViewModel:ViewModel() {

    val myInfoService=MyInfoService.instance()

    var myInfoLiveData = MutableLiveData<MyInfoReData>()
        private set

    //是否正在加载
    var loading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set
    /**
     * 获取个人信息
     */

    suspend fun getMyInfo(){
        loading=true
        val res=myInfoService.getMyInfo()
        if (res.data!=null){
            myInfoLiveData.value=res.data
        }else{
            error=res.message
        }

    }
}