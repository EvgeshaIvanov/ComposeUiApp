package com.example.composeuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
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
            .padding(start = 32.dp, end = 32.dp)
            .fillMaxWidth()
            .size(width = 0.dp, height = 150.dp),
        elevation = 20.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.secondary,
                            MaterialTheme.colors.primaryVariant,
                        )
                    )
                )
        ) {
            Column(
                Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Balance", color = Color.Black)
                Text(text = "$$money", color = Color.Black)
                Text(text = "$income%")
                Button(onClick = { }) {
                    Text(text = "Info")
                }
            }
        }

    }
}

@Composable
fun CurrencyInfo(list: List<CurrencyModel>) {
    list.forEach { model ->
        Box(Modifier.fillMaxWidth()) {
            Row(Modifier.padding(start = 8.dp, end = 8.dp)) {
                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = model.companyDefaultName, color = Color.White)
                    Text(text = model.companyShortName, color = Color.White)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = model.graphic, color = Color.White)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = model.defaultCurrency.toString(), color = Color.White)
                    Text(text = model.incomeCurrency.toString(), color = Color.White)
                }
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
            UserName(name = "Sample", surname = "Name")
            RandomData()
            CustomCardView(244000)
            Text(text = "Trending", color = Color.White, fontFamily = FontFamily.Cursive)
            CurrencyInfo(list = currencyListInfo)
        }
    }
}