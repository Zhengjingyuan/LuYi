package com.example.luyi.navigation

sealed class Screen(val route:String){
    object Home:Screen("Home")

    object Splash:Screen("Splash")

    object Login:Screen("Login")
}
