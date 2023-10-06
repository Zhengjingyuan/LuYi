package com.example.luyi.parent.diary.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.parent.diary.model.redata.DiaryListReData
import com.example.luyi.parent.diary.model.redata.DiaryReData
import com.example.luyi.parent.diary.network.DiaryService
import kotlinx.coroutines.launch
import java.io.File

class DiaryViewModel:ViewModel() {

    var diarylist= listOf(
        DiaryListReData("2022.5.31",11,"陪儿子"),
        DiaryListReData("2022.4.22",22,"出去散步"),
        DiaryListReData("2022.4.15",33,"玩游戏"),
        DiaryListReData("2022.4.05",44,"逛公园"),
        DiaryListReData("2022.4.01",55,"台风来了"),
        DiaryListReData("2022.3.28",66,"儿子长大了"),
        DiaryListReData("2022.2.21",77,"第一次去旅游"),
    )
    var diaryDetail:DiaryReData?=null

    var title by mutableStateOf("")
    var text by mutableStateOf("")

    var uptitle by mutableStateOf("")
    var uptext by mutableStateOf("")

    val imageFilePath: MutableLiveData<String> = MutableLiveData()
    val updateImageFilePath: MutableLiveData<String> = MutableLiveData()

    var error by mutableStateOf("")

    private val diaryService=DiaryService.instance()


    /**
     * 获取日记列表
     */

    suspend fun getDiaryList() {
        viewModelScope.launch {
            val res=diaryService.getDiaryList()
            try {
                val list = res.data
                diarylist = list!!
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 获取日记详情
     */

    suspend fun getDiaryDetail(did: String) {
        viewModelScope.launch {
            val res=diaryService.getDiaryDetail(did)
            try {
                val diary = res.data
                diaryDetail = diary
            } catch (e: Exception) {
                // 处理异常情况
                error=res.message
            }
        }
    }

    /**
     * 删除日记
     */

    suspend fun deletDiary(did: String){
        viewModelScope.launch {
            val res=diaryService.deletDiary(did)
            try{
                getDiaryList()

            }catch (e:Exception){
                error=res.message
            }
        }

    }

    /**
     * 添加日记
     */

    suspend fun addDiary(){
        // 获取图片文件路径
        val imagePath = imageFilePath.value

        // 创建File对象，如果图片文件路径不为空，则创建File对象；否则，传入null表示不传图片
        val imageFile = if (!imagePath.isNullOrEmpty()) {
            File(imagePath)
        } else {
            null
        }

        try {
            diaryService.addDiary(title,text,imageFile)
            getDiaryList()

        }catch (e:Exception){
            error=diaryService.addDiary(title,text,imageFile).message
        }

    }

    /**
     * 修改日记
     */

    suspend fun updateDiary(did:String){
        // 获取图片文件路径
        val imagePath = updateImageFilePath.value

        // 创建File对象，如果图片文件路径不为空，则创建File对象；否则，传入null表示不传图片
        val imageFile = if (!imagePath.isNullOrEmpty()) {
            File(imagePath)
        } else {
            null
        }
        try {
            diaryService.updateDiary(uptitle,uptext,imageFile,did)
            getDiaryList()

        }catch (e:Exception){
            error=diaryService.updateDiary(uptitle,uptext,imageFile,did).message
        }

    }


//    /**
//     * 刷新列表
//     */
//    private suspend fun refreshDiaryList() {
//        try {
//            val list = diaryService.getDiaryList().data
//            diaryList = list ?: emptyList()
//        } catch (e: Exception) {
//            // 处理异常情况
//            throw e
//        }
//    }
}