package com.example.luyi.parent.memorandum.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.luyi.parent.memorandum.model.entity.AddMemorandumRequest
import com.example.luyi.parent.memorandum.model.entity.ChangeMemorandumRequest
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData
import com.example.luyi.parent.memorandum.network.MemorandumService


class MemorandumViewModel:ViewModel() {


    var memorandumList by mutableStateOf(listOf(
    MemorandumReData("2022.5",true,66,"吃早饭","吃早饭吃早饭吃串串",55),
    MemorandumReData("2022.5",false,66,"吃午饭","吃早饭吃早饭吃串串",55),
    MemorandumReData("2022.5",false,66,"吃晚饭","吃早饭吃早饭吃串串",55),
    MemorandumReData("2022.5",true,66,"吃早饭","吃早饭吃早饭吃串串",55),
    MemorandumReData("2022.5",true,66,"吃早饭","吃早饭吃早饭吃串串",55),
    MemorandumReData("2022.5",false,66,"吃早饭","吃早饭吃早饭吃串串",55),
    )
        )
        private set
    var title by mutableStateOf("")

    var todo by mutableStateOf("")

    var done by mutableStateOf(false)


    var error by mutableStateOf("")
        private set

    val memorandumService=MemorandumService.instance()

    /**
     * 获取备忘录
     */

    suspend fun getMemorandum(){
        val res=memorandumService.getMemorandum()
        if (res.data!=null){
            memorandumList=res.data
        }else if (res.data==null){
            error=""
        }else{
            error=res.message
        }
    }

    /**
     * 添加备忘录
     */

    suspend fun addMemorandum(){
        val newMemorandum=AddMemorandumRequest(done,todo )
        try {
            memorandumService.addMemorandum(newMemorandum)
            //更新日记列表
            getMemorandum()
            //成功跳转

        }catch (e:Exception){
            error=memorandumService.addMemorandum(newMemorandum).message

        }

    }

    /**
     * 删除备忘录
     */


    suspend fun deletMemorandum(tid:Long){
        try {
            memorandumService.deletMemorandum(tid)
            // 删除成功后更新日记列表
            getMemorandum()

        }catch (e:Exception){
            error= memorandumService.deletMemorandum(tid).message
        }
    }

    /**
     * 更新备忘录
     */
    suspend fun updateMemorandum(tid: Long, done: Boolean){
        this.done =!done
        val updata=ChangeMemorandumRequest(done,tid)
        try {
            memorandumService.updataMemorandum(updata)
            //更新
            getMemorandum()
        }catch (e:Exception){
            error=memorandumService.updataMemorandum(updata).message
        }

    }



}