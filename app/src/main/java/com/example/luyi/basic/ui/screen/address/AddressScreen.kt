package com.example.luyi.basic.ui.screen.address

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.luyi.basic.ui.screen.address.ui.theme.Greenbk
import com.example.luyi.basic.ui.screen.address.ui.theme.LuYiTheme

class AddressScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Address()
                }
            }
        }
    }
}

@Composable
fun Address(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Greenbk)) {
        LazyColumn(){

        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview11() {
    LuYiTheme {
        Address()
    }
}