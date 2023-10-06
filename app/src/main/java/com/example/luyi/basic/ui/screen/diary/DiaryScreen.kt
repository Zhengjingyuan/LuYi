package com.example.luyi.basic.ui.screen.diary

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.luyi.R
import com.example.luyi.basic.ui.component.Diaryitem
import com.example.luyi.basic.ui.screen.diary.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.diary.ui.theme.OrangeBk
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Yellow100
import com.example.luyi.parent.diary.viewmodel.DiaryViewModel

class DiaryScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Diary()
                }
            }
        }
    }
}

@Composable
fun Diary(dvm:DiaryViewModel= viewModel()) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(OrangeBk)){
        Column(modifier = Modifier.weight(1f)) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
            ){
                items(dvm.diarylist){item->

                    Diaryitem(item)

                }

            }

        }

        Image(
            painter = painterResource(id = R.mipmap.diaryback_button),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(10.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
    LuYiTheme {
        Diary()
    }
}