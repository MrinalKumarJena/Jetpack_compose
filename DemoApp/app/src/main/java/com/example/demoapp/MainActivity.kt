package com.example.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.ReportDrawn
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoapp.ui.theme.DemoAppTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            DemoAppTheme {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Default Text")
                    Text(text = "Red Text", style = TextStyle(color = Color.Red))
                    Text(text = "Italic Text", fontStyle = FontStyle.Italic)
                    Text(text = "Large Text", fontSize = 30.sp)
                    Text(text = "Bold Text", fontWeight = FontWeight.Bold)
                    TextShadow()
                    MultipleStylesInText()
                    gradcolour()
                    BrushToaSpanOfText()
                    Opacity()
                    BasicMarqueeSample()
                    LayoutsDemo()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("lifecycle:On Start Started")
    }
    override fun onResume() {
        super.onResume()
        println("lifecycle:On Resume Started")
    }
    override fun onPause() {
        super.onPause()
        println("lifecycle:On Pause Started")
    }
    override fun onStop() {
        super.onStop()
        println("lifecycle:On Stop Started")
    }
    override fun onDestroy() {
        super.onDestroy()
        println("lifecycle:On Destroy Started")
    }

}
@Composable
fun TextShadow() {
    val offset = Offset(10.0f, 15.0f)
    Text(
        text = "Shadow Text",
        style = TextStyle(color = Color.Red,
            fontSize = 30.sp,
            shadow = Shadow(
                color = Color.Green, offset = offset, blurRadius = 3f
            )
        )
    )
}
@Composable
fun MultipleStylesInText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("M")
            }
            append("ultiple Style ")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                append("T")
            }
            append("ext")
        }, fontSize = 30.sp, fontWeight = FontWeight.Bold
    )
}
@Composable
fun gradcolour(){
    val gradientColors = listOf(Color.Yellow, Color.Green, Color.Blue)
    Text(
        text = "Gradient color text",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors
            )
        ), fontSize = 30.sp
    )
}

@Composable
fun BrushToaSpanOfText(){
    Text(
        text = buildAnnotatedString {
            append("All That\n")
            withStyle(
                SpanStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD700), Color(0xFFC0C0C0))

                    )
                )
            ) {
                append("Glitters")
            }
            append("\nIs Not Gold")
        }, fontSize = 30.sp
    )
}
@Composable
fun Opacity(){
    val mycolor = listOf(Color.Red, Color.Yellow, Color.Green, Color.Blue)
    val brush = Brush.linearGradient(colors = mycolor)
    
    val builtX = buildAnnotatedString {
        withStyle(
            SpanStyle(
                brush = brush, alpha = 8f
            )
        ) {
            append("Text in ")
        }
        withStyle(
            SpanStyle(
                brush = brush, alpha = 0.2f
            )
        ) {
            append("Compose")
        }
    }
    Text(text = builtX, fontSize = 40.sp)
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BasicMarqueeSample() {
    Column(Modifier.width(400.dp)) {
        Text(
            "Congratulations, India!.....India has won the T20 World Cup!",
            modifier = Modifier.basicMarquee(),
            fontSize = 50.sp
        )
    }
}
@Composable
fun LayoutsDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "TEXT1",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Red)
            )
            Text(
                text = "TEXT2",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Green)
            )
            Text(
                text = "TEXT3",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Blue)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TEXT1",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Red)
            )
            Text(
                text = "TEXT2",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Green)
            )
            Text(
                text = "TEXT3",
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Blue)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Magenta)
        ) {
            Text(
                text = "TEXT1",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .background(Color.Red)
            )
            Text(
                text = "TEXT2",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
                    .background(Color.Green)
            )
            Text(
                text = "TEXT3",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .background(Color.Blue)
            )
        }
    }
}
