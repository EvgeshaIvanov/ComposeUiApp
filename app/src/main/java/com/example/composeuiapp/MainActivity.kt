package com.example.composeuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeuiapp.ui.theme.ComposeUiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUiAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DayStatus() {
    val list = listOf("Morning", "Evening", "Night")
    Text(text = list[(0..2).random()], color = Color.White)
}

@Composable
fun UserName(name: String, surname: String) {
    Text(text = "$surname $name", color = Color.White)
}

@Composable
fun RandomData() {
    Text(text = "17 августа 2022 г.", color = Color.White)
}

@Composable
fun CustomCardView(money: Int) {
    val income = (1_000_000 / money) * 0.1
    Card(
        Modifier
            .size(width = 180.dp, height = 100.dp), backgroundColor = Color.DarkGray
    ) {
        Column() {
            Text(text = "Balance", color = Color.Black)
            Text(text = "$$money", color = Color.Black)
            Text(text = "$income%")
            Button(onClick = { }, modifier = Modifier.padding(top = 8.dp)) {
                Text(text = "Info")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUiAppTheme {
        Column(Modifier.background(Color.Black)) {
            DayStatus()
            UserName(name = "Eugene", surname = "Ivanov")
            RandomData()
            CustomCardView(244000)
        }
    }
}