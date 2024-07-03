package com.example.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.ReportDrawn
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
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

    buildAnnotatedString {
        withStyle(
            SpanStyle(
                brush = brush, alpha = .5f
            )
        ) {
            append("Text in ")
        }
        withStyle(
            SpanStyle(
                brush = brush, alpha = 1f
            )
        ) {
            append("Compose")
        }
    }
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