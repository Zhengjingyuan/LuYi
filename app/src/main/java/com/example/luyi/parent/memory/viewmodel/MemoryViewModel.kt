package com.example.luyi.parent.memory.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.parent.diary.model.entity.DiaryImage
import com.example.luyi.parent.diary.model.redata.DiaryListReData
import com.example.luyi.parent.diary.model.redata.DiaryReData
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData
import com.example.luyi.parent.memory.model.entity.DeletMemoryRequest
import com.example.luyi.parent.memory.model.entity.Memory
import com.example.luyi.parent.memory.network.MemoryService
import kotlinx.coroutines.launch
import java.io.File

class MemoryViewModel:ViewModel() {
    val memoryService=MemoryService.instance()

    private val _memoryList = MutableLiveData<List<Memory>?>()
    val memoryList: LiveData<List<Memory>?> = _memoryList

    private val _diaryList = MutableLiveData<List<DiaryReData>?>()
    val diaryList: LiveData<List<DiaryReData>?> = _diaryList

    private val _todoList = MutableLiveData<List<MemorandumReData>?>()
    val todoList: LiveData<List<MemorandumReData>?> = _todoList

    val addImageFilePath: MutableLiveData<String> = MutableLiveData()

    var adddetail by mutableStateOf("")

    val upImageFilePath: MutableLiveData<String> = MutableLiveData()

    var updetail by mutableStateOf("")

    var error by mutableStateOf("")


    /**
     * 获取回忆之路列表
     */

    suspend fun getMemory() {
        val res = memoryService.getMemory()

        val list1 = res.data?.diaryAxis
        val list2 = res.data?.memoryAxis
        val list3 = res.data?.todoAxis
        if (list1!=null){
            _diaryList.value=list1
        }

        if (list2!=null){
        _memoryList.value = list2
        }

        if (list3!=null){
            _todoList.value = list3
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
            memoryService.addMemory(imageFile,0,currentTime,adddetail)
            getMemory()
        } catch (e: Exception) {

            error=memoryService.addMemory(imageFile,0,currentTime,adddetail).message
        }
    }

    /**
     * 删除回忆
     */

    suspend fun deletMemory(meid:Long){
            val res=memoryService.deletMemory(meid)
            try{
                getMemory()

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
            memoryService.updateMemory(imageFile,0,currentTime,updetail,meid)
            getMemory()
        } catch (e: Exception) {

            error=memoryService.addMemory(imageFile,0,currentTime,updetail).message
        }

    }
}