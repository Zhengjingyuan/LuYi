package com.example.luyi.basic.ui.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.luyi.R
import com.example.luyi.basic.ui.component.ui.theme.Blue40
import com.example.luyi.basic.ui.component.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue300
import com.example.luyi.parent.memorandum.model.redata.MemorandumReData

class MemorandumClickItem : ComponentActivity() {
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
fun MemorandumClickitem(Item:MemorandumReData) {
    Row (modifier = Modifier
        .size(324.dp, 191.dp)
        .clip(RoundedCornerShape(16.dp))
        .padding(vertical = 2.dp)
        .background(if(Item.done) Blue300 else Blue40)
    ){
        Spacer(modifier = Modifier.width(10.dp))

        Image(
            painter = painterResource(id = R.drawable.eat),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp, 19.dp)
                .align(Alignment.CenterVertically)

        )

        Spacer(modifier = Modifier.width(10.dp))

        Image(
            painter = painterResource(id = R.drawable.line),
            contentDescription = null,
            modifier = Modifier.size(6.dp,191.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column (modifier = Modifier.fillMaxSize()){
            Column (modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()){
                Text(
                    text = Item.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 34.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis)


                Text(
                    text = Item.todo,
                    color = Color.White,
                    fontSize = 26.sp,
                    maxLines = 2,
                    lineHeight = 10.sp,
                    overflow = TextOverflow.Ellipsis,

                    )

            }


                Row (modifier = Modifier.size(220.dp,39.dp)){
                    Image(
                        painter = painterResource(id =if(Item.done) R.drawable.finish else R.drawable.unfinish),
                        contentDescription = null,
                        modifier = Modifier.size(104.dp,39.dp)
                    )

                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        painter = painterResource(id =if(Item.done) R.drawable.setunfinish else R.drawable.setfinish),
                        contentDescription = null,
                        modifier = Modifier.size(98.dp,38.dp)
                    )

                }




        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    LuYiTheme {

    }
}