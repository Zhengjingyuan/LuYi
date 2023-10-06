package com.example.luyi.basic.ui.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luyi.basic.ui.component.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.diary.ui.theme.Orange100
import com.example.luyi.basic.ui.screen.diary.ui.theme.Orange200
import com.example.luyi.basic.ui.screen.diary.ui.theme.Red40
import com.example.luyi.parent.diary.model.redata.DiaryListReData

class DiaryItem : ComponentActivity() {
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
fun Diaryitem(Item:DiaryListReData){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .clip(RoundedCornerShape(50.dp))
        .padding(  2.dp)
        .background(Orange200)

        ) {

        Box(
            modifier = Modifier
                .height(50.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Orange100)
                .align(Alignment.CenterVertically)
                .weight(0.4f),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = Item.title,
                color= Red40,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                maxLines = 1
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ){
        Text(
            text = Item.datetime,
            color= Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            )
        }


    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
    LuYiTheme {

    }
}