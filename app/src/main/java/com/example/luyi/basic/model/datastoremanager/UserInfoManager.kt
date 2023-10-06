package com.example.luyi.basic.model.datastoremanager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.luyi.basic.model.entity.LoginRequest
import com.example.luyi.basic.model.redata.LoginReData
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserInfoManager(private val context: Context) {
    companion object{
        private val Context.userStore: DataStore<Preferences> by preferencesDataStore("user_store")
    }

    val LOGGED = booleanPreferencesKey("LOGGED")
    val LOGIN_DATA = stringPreferencesKey("LOGIN_DATA")
    val logged: Flow<Boolean> = context.userStore.data.map { it[LOGGED] ?: false }
    val loginData: Flow<LoginReData?> = context.userStore.data.map {
        val json = it[LOGIN_DATA]
        if (json != null) {
            Gson().fromJson(json, LoginReData::class.java)
        } else {
            null
        }
    }
    /**
     * 存储用户信息
     */
    suspend fun save(loginData: LoginRequest) {
        context.userStore.edit {
            it[LOGGED] = loginData != null
            it[LOGIN_DATA] = Gson().toJson(loginData)
        }
    }
    suspend fun clear() {
        context.userStore.edit {
            it[LOGGED] = false
            it[LOGIN_DATA] = ""
        }

}
    fun getToken(): Flow<String?> {
        val tokenFlow: Flow<String?> = loginData.map { it?.token } // 获取token的Flow
        return tokenFlow

    }


}