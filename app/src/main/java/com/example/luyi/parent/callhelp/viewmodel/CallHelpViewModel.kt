package com.example.luyi.parent.callhelp.viewmodel

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.luyi.parent.callhelp.network.CallHlepService

class CallHelpViewModel:ViewModel() {
    val callService=CallHlepService.instance()

    var phoneNumber: MutableLiveData<String> = MutableLiveData()
        private set

    var number: String? = null
        get() = phoneNumber.value
        private set

    var addphone by mutableStateOf("")

    var updatephone by mutableStateOf("")

    var error by mutableStateOf("")

    /**
     * 获取电话
     */

    suspend fun getPhone(){
        val res=callService.getPhone()
        if (res.data!=null){
        number= res.data.bindphone!!
        }else if (res.data==null)
        {
            error="未设置紧急电话"
        }else{
            error=res.message
        }
    }

    /**
     * 绑定电话
     */


    suspend fun addPhone(){
        val res=callService.addPhone(addphone)
        if (res.data!=null){
            //刷新电话
            getPhone()
            //跳转

        }else{
            error=res.message
        }
    }

    /**
     * 更新电话
     */

    suspend fun updatePhone(){
        val res=callService.updatePhone(updatephone)
        if (res.data!=null){
            //刷新电话
            getPhone()
            //跳转
        }else{
            error=res.message
        }
    }
}