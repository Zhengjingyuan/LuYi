package com.example.luyi.basic.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.Background
import com.example.luyi.basic.ui.screen.ui.theme.ui.theme.LuYiTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

class GuideScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuYiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GuideContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun GuideContent() {
    val pagerState = com.google.accompanist.pager.rememberPagerState(pageCount = 3)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 引导页内容
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) {

               when (currentPage) {
                   0 -> GuideItem1()
                   1 -> GuideItem2()
                   2 -> GuideItem3()
                   else -> ""
               }



        }
        // 圆点指示器
        Row(
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                val dotColor = if (index == pagerState.currentPage) Color.Red else Color.White
                Spacer(modifier = Modifier.width(50.dp))
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(dotColor)


                )
            }
        }
    }
}



@Composable
fun GuideItem1() {
    val fadeIn = remember {
        fadeIn(
            animationSpec = tween(durationMillis = 1000)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "Hi，我是您的记忆守护者\n\n开始唤起珍贵回忆...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(160.dp))


        Image(
            painter = painterResource(id = R.mipmap.guide1),
            contentDescription = "Guide Image",
            modifier = Modifier.size(260.dp)
        )


    }
}
@Composable
fun GuideItem2() {
    val fadeIn = remember {
        fadeIn(
            animationSpec = tween(durationMillis = 1000)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "通过简单有趣小游戏\n\n增强您的记忆力...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(160.dp))


        Image(
            painter = painterResource(id = R.mipmap.guide2),
            contentDescription = "Guide Image",
            modifier = Modifier.size(260.dp)
        )


    }
}
@Composable
fun GuideItem3() {
    val fadeIn = remember {
        fadeIn(
            animationSpec = tween(durationMillis = 1000)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        Text(
            text = "记录每个宝贵瞬间\n\n也不错过任何重要事件...",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(160.dp))


        Image(
            painter = painterResource(id = R.mipmap.guide3),
            contentDescription = "Guide Image",
            modifier = Modifier.size(260.dp)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    LuYiTheme {
        GuideContent()
    }
}