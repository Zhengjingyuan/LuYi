package com.example.luyi.basic.ui.screen

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.luyi.R
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Background
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue100
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Blue200
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.LuYiTheme
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Orange100
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Redsos
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Yellow100
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.luyi.basic.ui.component.MemorandumItem
import com.example.luyi.parent.memorandum.viewmodel.MemorandumViewModel

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home(vm:MemorandumViewModel= viewModel()) {

   var isMemoClicked by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
    ){

        Row (modifier = Modifier
            .height(350.dp)
            .width(400.dp)
            .padding(16.dp)
        ){
            Spacer(modifier = Modifier.width(10.dp))
            //备忘录
            Column {
                Spacer(modifier = Modifier.size(148.dp,45.dp))
                Column(modifier = Modifier
                    .size(148.dp, 287.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Blue100))
                {
                    Spacer(modifier = Modifier.height(10.dp))
                    Row {
                        Spacer(modifier = Modifier.width(8.dp))
                        Image(
                            painter = painterResource(id = R.mipmap.memorandum_text),
                            contentDescription = null,
                            modifier = Modifier
                                .size(59.dp,41.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Image(
                            painter = painterResource(id = R.drawable.book),
                            contentDescription = null,
                            modifier = Modifier
                                .size(59.dp,46.dp)
                        )
                    }
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Blue200)
                    ){
                        //备忘录List
                        LazyColumn(modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)){
                            items(vm.memorandumList){item->
                                MemorandumItem(item)

                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column(modifier = Modifier
                .padding(16.dp)) {
                //天气
                Image(
                    painter = painterResource(id = R.mipmap.weather),
                    contentDescription = null,
                    modifier = Modifier
                        .size(176.dp,153.dp)
                )

                //一键求助
                Box(modifier = Modifier
                    .size(156.dp, 143.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Redsos)){
                    Image(
                        painter = painterResource(id = R.mipmap.sos_bk),
                        contentDescription = "Guide Image",
                        modifier = Modifier
                            .size(153.dp,157.dp),
                        )

                    Image(
                        painter = painterResource(id = R.mipmap.sos),
                        contentDescription = "Guide Image",
                        modifier = Modifier
                            .size(72.dp, 114.dp)
                            .align(Alignment.Center),

                    )
                }
            }
        }



        Row (modifier = Modifier
            .height(200.dp)
            .width(400.dp)
            .padding(8.dp)){
            Spacer(modifier = Modifier.width(10.dp))
            //日记
            Row(modifier = Modifier
                .height(175.dp)
                .width(170.dp)
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Yellow100)
            ) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.diary),
                        contentDescription = "Guide Image",
                        modifier = Modifier.size(37.dp,40.dp))

                    Image(
                        painter = painterResource(id = R.mipmap.diary_text),
                        contentDescription = "Guide Image",
                        modifier = Modifier.size(19.dp,126.dp))

                }
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ){
                    Box(modifier = Modifier
                        .size(101.dp, 100.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .align(Alignment.CenterHorizontally)
                    ){
                        Image(
                            painter = painterResource(id = R.mipmap.newdiary),
                            contentDescription = "Guide Image",
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Box(modifier = Modifier
                        .size(101.dp, 80.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .align(Alignment.CenterHorizontally)
                    ){
                        Image(
                            painter = painterResource(id = R.mipmap.mydiary),
                            contentDescription = "Guide Image",
                            modifier = Modifier.fillMaxSize()

                        )
                    }

                }


            }

            Spacer(modifier = Modifier.width(20.dp))

            //唤起回忆
            Box(modifier =Modifier.size(160.dp,180.dp) ){
                Image(
                    painter = painterResource(id = R.mipmap.callmemory),
                    contentDescription = "Guide Image",
                    modifier = Modifier.fillMaxSize()
                )
            }

        }



        Column (modifier = Modifier
            .size(335.dp, 130.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Orange100)
            .align(Alignment.CenterHorizontally)){

            Image(
                painter = painterResource(id = R.drawable.person),
                contentDescription = "Guide Image",
                modifier = Modifier
                    .size(75.dp)
                    .padding(10.dp)
            )
            Image(
                painter = painterResource(id = R.mipmap.mymemory_text),
                contentDescription = "Guide Image",
                modifier = Modifier
                    .size(190.dp, 75.dp)
                    .align(Alignment.End)
            )

        }

        Spacer(modifier = Modifier.height(26.dp))

        Image(
            painter = painterResource(id = R.mipmap.speak),
            contentDescription = "Guide Image",
            modifier = Modifier
                .size(352.dp, 116.dp)
                .align(Alignment.CenterHorizontally)
        )



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    LuYiTheme {
        Home()
    }
}