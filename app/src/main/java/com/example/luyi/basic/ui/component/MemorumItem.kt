package com.example.luyi.basic.ui.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luyi.R
import com.example.luyi.basic.ui.component.ui.theme.Blue40
import com.example.luyi.basic.ui.component.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue300
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

class MemorumItem : ComponentActivity() {
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
fun MemorandumItem(Item:MemorandumReData){
    Row (modifier = Modifier
        .size(138.dp, 55.dp)
        .clip(RoundedCornerShape(8.dp))
        .padding(vertical = 2.dp)
        .background(if(Item.done) Blue300 else Blue40 )
        ){
        Image(
            painter = painterResource(id = R.drawable.eat),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .align(Alignment.CenterVertically)

        )
        Image(
            painter = painterResource(id = R.drawable.line),
            contentDescription = null,
            modifier = Modifier.size(6.dp,131.dp)
        )
        Column (modifier = Modifier.fillMaxSize()){
            Row {
                Text(
                    text = Item.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)

                Image(
                    painter = painterResource(id = if (Item.done) R.drawable.yes else R.drawable.no),
                    contentDescription = null,
                    modifier = Modifier
                        .size(16.dp)
                        .align(Alignment.CenterVertically)

                )
            }

            Column (modifier = Modifier.fillMaxSize()){
                Text(
                    text = Item.todo,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 7.sp,
                    maxLines = 2,
                    lineHeight = 10.sp,
                    overflow = TextOverflow.Ellipsis,

                )


            }


        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    LuYiTheme {

    }
}