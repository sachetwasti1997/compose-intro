package com.sachet.introtocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sachet.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                Greeting(name = "Hello User")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Gray
    ) {
        var counter by remember{
            mutableStateOf(100)
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$$counter",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 39.sp
                )
            )
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(){
                counter += it
            }
        }
    }
}

@Composable
fun CreateCircle(increment: (Int) -> Unit) {
    Card(
        modifier = Modifier.size(60.dp).clickable { increment(1) },
        shape = CircleShape,
        elevation = 4.dp,

    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        Greeting("Hello User")
    }
}