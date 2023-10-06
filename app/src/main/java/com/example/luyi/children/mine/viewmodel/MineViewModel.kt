package com.example.luyi.children.mine.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.children.mine.model.entity.BindRequest
import com.example.luyi.children.mine.model.redata.MyParentsRedata
import com.example.luyi.children.mine.network.MyService
import com.example.luyi.parent.contact.model.entity.AddAddressRequest
import com.example.luyi.parent.diary.model.redata.DiaryListReData
import kotlinx.coroutines.launch

class MineViewModel:ViewModel() {
    private val myService=MyService.instance()

    private val _parentList = MutableLiveData<List<MyParentsRedata>>()
    val parentList: LiveData<List<MyParentsRedata>> = _parentList


    var username by mutableStateOf("")
    var phone by mutableStateOf("")
    var realname by mutableStateOf("")

    var id_number by mutableStateOf("")
    var uid by mutableStateOf(0L)


    var error by mutableStateOf("")

    /**
     * 获取绑定亲属
     */

    suspend fun getParent(){
        viewModelScope.launch {
            val res=myService.getParent()
            try {
                val list = res.data
                _parentList.value=list

            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 添加绑定
     */
    suspend fun postBind(){
        val post= BindRequest(id_number,phone,realname,uid,username)
        val res=myService.postBind(post)
        if (res.data!=null){
            getParent()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 删除绑定
     */
    suspend fun deletBind(uid:Long){
        val res=myService.deletBind(uid)
        if (res.data!=null){
            getParent()
            //跳转
        }else{
            error=res.message
        }
    }
}