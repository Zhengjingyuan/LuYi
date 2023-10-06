package com.example.luyi.basic.ui.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luyi.R
import com.example.luyi.basic.ui.component.ui.theme.Green100
import com.example.luyi.basic.ui.component.ui.theme.Green200
import com.example.luyi.basic.ui.component.ui.theme.LuYiTheme

class AddressItem : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Addressitem()
                }
            }
        }
    }
}

@Composable
fun Addressitem(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(128.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(Green200)
        .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically) {


        Image(
            painter = painterResource(id = R.mipmap.profile),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.width(30.dp))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
        ) {
            Box(modifier = Modifier
                .size(175.dp, 65.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Green100),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "儿子小明",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(text = "手动创建的联系人",
                color = Color.White,
                fontSize = 24.sp)
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview12() {
    LuYiTheme {
        Addressitem()
    }
}