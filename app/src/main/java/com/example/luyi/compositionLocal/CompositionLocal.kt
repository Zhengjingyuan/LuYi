package com.example.luyi.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.example.luyi.basic.viewmodel.UserViewModel

val LocalUserModel= compositionLocalOf<UserViewModel>{
    error("userViewModel not found ")
}