package com.splicer.jetpackcomposelesson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircleItem()
            }
//            Column(modifier =  Modifier.verticalScroll(rememberScrollState())) {
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//                ListItem("Zac Efron", "Actor")
//            }
        }
    }
}

@Composable
private fun ListItem(name: String, prof: String) {
    val counter = remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { counter.value++ },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = counter.value.toString())
                    Text(text = prof)
                }

            }
        }
    }
}

@Composable
private fun CircleItem() {
    val counter = remember {
        mutableStateOf(0)
    }
    val color = remember {
        mutableStateOf(Blue)
    }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                when (++counter.value) {
                    10 -> color.value = Red
                    20 -> color.value = Green
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = counter.value.toString(), style = TextStyle(color = White), fontSize = 20.sp)
    }
}