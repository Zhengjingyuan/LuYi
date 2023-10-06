package com.example.luyi.basic.ui.screen.memorandum

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.luyi.R
import com.example.luyi.basic.ui.screen.memorandum.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue100
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue200
import com.example.luyi.parent.memorandum.viewmodel.MemorandumViewModel

class NewMemorandumScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewMemorandum()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewMemorandum(vm: MemorandumViewModel = viewModel()) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Blue100)
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier
            .size(340.dp,700.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Blue200)
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally) {


                // 其他布局内容
                TextField(
                    value = vm.title,
                    onValueChange = { newValue -> vm.title = newValue },
                    label = { Text(text = "输入标题...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp),
                    shape = RectangleShape, // 设置无边框
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent, // 设置背景色为透明
                        focusedIndicatorColor = Color.Transparent, // 设置聚焦时的指示器颜色为透明
                        unfocusedIndicatorColor = Color.Transparent // 设置非聚焦时的指示器颜色为透明
                    ),
                    maxLines = 1
                )

                Image(
                    painter = painterResource(id = R.drawable.horiline),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(3.dp)
                )


                TextField(
                    value = vm.todo,
                    onValueChange = { newValue -> vm.todo = newValue },
                    label = { Text(text = "输入内容...") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RectangleShape, // 设置无边框
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent, // 设置背景色为透明
                        focusedIndicatorColor = Color.Transparent, // 设置聚焦时的指示器颜色为透明
                        unfocusedIndicatorColor = Color.Transparent // 设置非聚焦时的指示器颜色为透明
                    )
                )
        }

        Image(
            painter = painterResource(id = R.mipmap.newmemorandum_button),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp)
                .padding(6.dp)
        )




    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    LuYiTheme {
        NewMemorandum()
    }
}