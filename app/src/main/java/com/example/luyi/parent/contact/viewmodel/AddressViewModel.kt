package com.example.luyi.parent.contact.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.parent.contact.model.entity.AddAddressRequest
import com.example.luyi.parent.contact.model.entity.TimeLineRequest
import com.example.luyi.parent.contact.model.entity.UpdateAddressRequest
import com.example.luyi.parent.contact.model.redata.AddArrayRedata
import com.example.luyi.parent.contact.model.redata.AddDetailRedata
import com.example.luyi.parent.contact.model.redata.BindArrayRedata
import com.example.luyi.parent.contact.model.redata.BindDetailRedata
import com.example.luyi.parent.contact.network.ContactService
import com.example.luyi.parent.diary.model.redata.DiaryListReData
import com.example.luyi.parent.diary.model.redata.DiaryReData
import kotlinx.coroutines.launch

class AddressViewModel:ViewModel() {

    var addList= listOf(
        AddArrayRedata(11,"儿子小明","123","",""),
        AddArrayRedata(11,"儿子小明","123","",""),
        AddArrayRedata(11,"儿子小明","123","",""),
        AddArrayRedata(11,"儿子小明","123","","")

    )

    var bindList= listOf(
        BindArrayRedata(0,"儿子忠明","111","","",12,""),
        BindArrayRedata(0,"儿子忠明","111","","",12,""),
        BindArrayRedata(0,"儿子忠明","111","","",12,""),
        BindArrayRedata(0,"儿子忠明","111","","",12,""),
    )

    var addDetail:AddDetailRedata?=null
    var bindDetail:BindDetailRedata?=null


    var nickname by mutableStateOf("")
    var realname by mutableStateOf("")
    var phone by mutableStateOf("")

    var upnickname by mutableStateOf("")
    var uprealname by mutableStateOf("")
    var upphone by mutableStateOf("")

    var addremark by mutableStateOf("")

    var bindremark by mutableStateOf("")

    var upaddremark by mutableStateOf("")

    var upbindremark by mutableStateOf("")

    var error by mutableStateOf("")

    private val addressService=ContactService.instance()

    /**
     * 获取通讯录列表
     */

    suspend fun getAddressList(){
        viewModelScope.launch {
            val res=addressService.getAddress()
            try {
                val list1 = res.data?.add
                if (list1 != null) {
                    addList = list1
                }
                val list2=res.data?.bind
                if (list2 != null) {
                    bindList=list2
                }
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * add通讯录详情
     */

    suspend fun getAddDetail(aid: String) {
        viewModelScope.launch {
            val res=addressService.getAddDtail(aid)
            try {
                val detail = res.data
                addDetail = detail
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * bind通讯录详情
     */

    suspend fun getBindDetail(aid: String) {
        viewModelScope.launch {
            val res=addressService.getBindDtail(aid)
            try {
                val detail = res.data
                bindDetail = detail

                getAddressList()
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 添加通讯录
     */
    suspend fun postAddress(){
        val post=AddAddressRequest(nickname,phone,realname)
        val res=addressService.addAddress(post)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 修改通讯录
     */
    suspend fun updateAddress(aid:Long){
        val update=UpdateAddressRequest(aid,upnickname,upphone,uprealname)
        val res=addressService.updataAddress(update)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 删除通讯录
     */
    suspend fun deletAddress(aid:Long){
        val res=addressService.deletAddress(aid)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 添加Add时间轴
     */
    suspend fun postAddTimeline(aid: Long){
        //此处aid为通讯录某人的id
        val post=TimeLineRequest(aid,addremark)
        val res=addressService.addTimeline(post)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 添加Bind时间轴
     */
    suspend fun postBindTimeline(aid: Long){
        //此处aid为通讯录某人的id
        val post=TimeLineRequest(aid,addremark)
        val res=addressService.bindTimeline(post)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 删除add时间轴
     */
    suspend fun deletAddTimeline(adrtlid:Long){
        val res=addressService.deletAddAddress(adrtlid)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 删除bind时间轴
     */
    suspend fun deletBindTimeline(adrtlid:Long){
        val res=addressService.deletBindAddress(adrtlid)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 修改Add时间轴
     */
    suspend fun upAddTimeline(adrtlid:Long){
        val update=TimeLineRequest(adrtlid,upaddremark)
        val res=addressService.upAddTimeline(update)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }

    /**
     * 修改Bind时间轴
     */
    suspend fun upBindTimeline(adrtlid:Long){
        val update=TimeLineRequest(adrtlid,upbindremark)
        val res=addressService.upBindTimeline(update)
        if (res.data!=null){
            getAddressList()
            //跳转
        }else{
            error=res.message
        }
    }
}