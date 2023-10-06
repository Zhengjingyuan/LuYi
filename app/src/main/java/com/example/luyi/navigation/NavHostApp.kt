package com.example.luyi.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.luyi.basic.ui.screen.AnimatedSplashScreen
import com.example.luyi.basic.viewmodel.UserViewModel
import com.example.luyi.compositionLocal.LocalUserModel
import com.example.luyi.navigation.ui.theme.LuYiTheme

class NavHostApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun NavHostContent(){
    val navigationController = rememberNavController()

    CompositionLocalProvider(LocalUserModel provides UserViewModel(LocalContext.current)) {
        val userViewModel= LocalUserModel.current

        NavHost(
            navController = navigationController,
            startDestination = Screen.Splash.route
        ) {
            composable(Screen.Splash.route) {
                AnimatedSplashScreen(
                    onNavigationToHome = {
                        if (userViewModel.logged){
                            navigationController.navigate(Screen.Home.route)
                        }else{
                            navigationController.navigate(Screen.Login.route)
                        }
                    })
            }
//            composable(Screen.Home.route) {
//                HomeContent(onNavigationToLogin = {
//                    navigationController.navigate(Screen.Login.route)
//                })
//            }
//            composable(Screen.Login.route){
//                LoginContent(
//                    LoginOnNavigationToHome = {
//                        navigationController.navigate(Screen.Home.route)
//                    })
//            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    LuYiTheme {

    }
}