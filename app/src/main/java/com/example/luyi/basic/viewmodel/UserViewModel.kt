package com.example.luyi.basic.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.luyi.basic.model.datastoremanager.UserInfoManager
import com.example.luyi.basic.model.entity.LoginRequest
import com.example.luyi.basic.network.service.LoginService
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.luyi.basic.model.redata.LoginReData
import kotlinx.coroutines.delay
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class UserViewModel(context: Context):ViewModel() {

    private val userInfoManager= UserInfoManager(context)

    private val loginService=LoginService.instance()

    var username by mutableStateOf("")
    var password by mutableStateOf("")



    var user:LoginReData?=null
        private set

    init {
        viewModelScope.launch {
            userInfoManager.loginData.collect {
                user = it
            }
        }
    }

    val logged:Boolean
        get() {
            return user!=null
        }

    //是否正在登录
    var loading by mutableStateOf(false)
        private set

    var error by mutableStateOf("")
        private set

    /**
     * 登录操作
     *
     */

    suspend fun login(LoginOnNavigationToHome:()->Unit){
        loading=true
        delay(5000)
        val login_user = LoginRequest(username, md5(password))
        val res= loginService.signIn(login_user)
        if(res.data!=null){
            userInfoManager.save(login_user)
            user = res.data
            LoginOnNavigationToHome.invoke()

        }else{
            //失败
            error=res.message
        }
        loading=false

    }

    /**
     * 清空用户登录数据
     *
     */

    fun Clear(onNavigationToLogin:()->Unit){
        viewModelScope.launch {
            userInfoManager.clear()//清除本地数据存储
            user=null//置空内存数据
        }
        onNavigationToLogin.invoke()
    }


    private fun md5(input: String): String {
        try {
            val md = MessageDigest.getInstance("MD5")
            val messageDigest = md.digest(input.toByteArray())
            val no = BigInteger(1, messageDigest)
            var hashText = no.toString(16)
            while (hashText.length < 32) {
                hashText = "0$hashText"
            }
            return hashText
        } catch (e: NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
    }
}