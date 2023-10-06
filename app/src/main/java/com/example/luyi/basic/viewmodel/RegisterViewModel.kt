package com.example.luyi.basic.viewmodel
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.luyi.basic.model.entity.RegisterRequest
import com.example.luyi.basic.network.service.CaptchaService
import com.example.luyi.basic.network.service.RegisterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterViewModel:ViewModel() {

    private val registerService=RegisterService.instance()
    private val captchaService=CaptchaService.instance()

    var username by mutableStateOf("")
    var nickname by mutableStateOf("")
    var password by mutableStateOf("")
    var phone by mutableStateOf("")
    var identity by mutableStateOf(0L)
    var captcha by mutableStateOf("")

    var repassword by mutableStateOf("")

    suspend fun register(){
        if (isInputValid()) {
            val register_user=RegisterRequest(captcha, identity,nickname,password,phone,username)
            val res = withContext(Dispatchers.IO) {
                registerService.signUp(register_user)
            }
            if (res.data!=null){
                /*成功*/
            }else{
                //失败
                val message=res.message
                Log.i("===","$message")

            }
         }
    }
    suspend fun sendCaptcha(){
        if(PhoneIsValid(phone)){
            val res = withContext(Dispatchers.IO) {
                captchaService.sendCaptcha(phone)
            }
            if (res.data!=null){
                /*成功*/

            }else{
            /*失败*/

            }
        }else{
            Log.i("===","请输入正确格式的电话！")
        }

    }

    private fun isInputValid():Boolean{
        if (captcha.isEmpty() || identity !in listOf(0L, 1L) || nickname.isEmpty() ||
            password.isEmpty() || phone.isEmpty() || username.isEmpty()) {
            Log.i("===", "请将信息补充完整")
            return false

        }
        if (password.length < 8) {
            Log.i("===", "密码长度不能少于8位")
            return false
        }
        if (!password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+\$).{8,}\$"))) {
            Log.i("===", "密码必须包含至少一个数字、一个小写字母、一个大写字母、一个特殊字符(@#$%^&+=)且不能包含空格")
            return false
        }
        if (password!=repassword){
            Log.i("===","两次密码不相同！")
            return false
        }
        return true
    }

    fun PhoneIsValid(phoneNumber: String): Boolean {
        // 校验电话号码
        val regex = Regex("^1[3456789]\\d{9}$")

        return phoneNumber.matches(regex)
    }
}