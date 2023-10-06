package com.example.luyi.children.infomation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.children.infomation.network.InfomationService
import com.example.luyi.parent.diary.model.redata.DiaryListReData
import com.example.luyi.parent.diary.model.redata.DiaryReData
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData
import com.example.luyi.parent.memory.model.entity.Memory
import kotlinx.coroutines.launch
import java.io.File

class InfomationViewModel:ViewModel() {
    val infomationService=InfomationService.instance()

    //pid为绑定亲属id
    var pid by mutableStateOf("")

    //亲属日记
    private val _diaryList = MutableLiveData<List<DiaryListReData>>()
    val diaryList: LiveData<List<DiaryListReData>> = _diaryList

    //亲属回忆之路
    private val _selectedDiary = MutableLiveData<DiaryReData>()
    val selectedDiary: LiveData<DiaryReData> = _selectedDiary

    private val _memoryList = MutableLiveData<List<Memory>?>()
    val memoryList: LiveData<List<Memory>?> = _memoryList

    private val _mdiaryList = MutableLiveData<List<DiaryReData>?>()
    val mdiaryList: LiveData<List<DiaryReData>?> = _mdiaryList

    private val _mtodoList = MutableLiveData<List<MemorandumReData>?>()
    val mtodoList: LiveData<List<MemorandumReData>?> = _mtodoList

    val addImageFilePath: MutableLiveData<String> = MutableLiveData()

    var adddetail by mutableStateOf("")

    val upImageFilePath: MutableLiveData<String> = MutableLiveData()

    var updetail by mutableStateOf("")

    var error by mutableStateOf("")


    /**
     * 获取亲属日记列表
     */

    suspend fun getDiaryList() {
        //pid为绑定亲属id
        viewModelScope.launch {
            val res=infomationService.getParentDiary(pid)
            try {
                val list = res.data
                _diaryList.value = list!!
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 获取亲属日记详情
     */

    suspend fun getDiaryDetail(did: String) {
        viewModelScope.launch {
            val res=infomationService.getParentDiaryDetail(did)
            try {
                val diary = res.data
                _selectedDiary.value = diary
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 获取亲属回忆之路列表
     */

    suspend fun getMemory(pid: String) {
        val res = infomationService.getParentMemory(pid)

        val list1 = res.data?.diaryAxis
        val list2 = res.data?.memoryAxis
        val list3 = res.data?.todoAxis
        if (list1!=null){
            _mdiaryList.value=list1
        }

        if (list2!=null){
            _memoryList.value = list2
        }

        if (list3!=null){
            _mtodoList.value = list3
        }

    }

    /**
     * 添加回忆
     */

    suspend fun addMemory(){
        // 获取图片文件路径
        val imagePath = addImageFilePath.value

        // 创建File对象，如果图片文件路径不为空，则创建File对象；否则，传入null表示不传图片
        val imageFile = if (!imagePath.isNullOrEmpty()) {
            File(imagePath)
        } else {
            null
        }

        val currentTime = System.currentTimeMillis().toString()

        try {
            infomationService.addMemory(imageFile,1,currentTime,adddetail)
            getMemory(pid)
        } catch (e: Exception) {

            error=infomationService.addMemory(imageFile,0,currentTime,adddetail).message
        }
    }

    /**
     * 删除回忆
     */

    suspend fun deletMemory(meid:Long){
        val res=infomationService.deletParentMemory(meid)
        try{
                getMemory(pid)

        }catch (e:Exception){
            error=res.message
        }
    }

    /**
     * 修改回忆
     */

    suspend fun updateMemory(meid:Int){
        // 获取图片文件路径
        val imagePath = upImageFilePath.value

        // 创建File对象，如果图片文件路径不为空，则创建File对象；否则，传入null表示不传图片
        val imageFile = if (!imagePath.isNullOrEmpty()) {
            File(imagePath)
        } else {
            null
        }

        val currentTime = System.currentTimeMillis().toString()

        try {
            infomationService.updateParentMemory(imageFile,0,currentTime,updetail,meid)
            getMemory(pid)
        } catch (e: Exception) {

            error=infomationService.updateParentMemory(imageFile,0,currentTime,updetail,meid).message
        }

    }


}