package com.example.demoapp

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.ReportDrawn
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.demoapp.ui.theme.DemoAppTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            DemoAppTheme {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                   /* Text(text = "Default Text")
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
                    UIComponentsDemo()
                    LoginScreen()
                    MyApp()
                    examplescreen()*/
                    Listexample()
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

@Composable
fun UIComponentsDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            Button(onClick = { }) {
                Text("Filled")
            }
            FilledTonalButton(onClick = { }, shape = RectangleShape) {
                Text(text = "Tonal")
            }
            OutlinedButton(onClick = { }, shape = RoundedCornerShape(30)) {
                Text("Outlined")
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(30.dp)) {
            TextButton(onClick = { }) {
                Text("Text Button")
            }
            ElevatedButton(onClick = { }) {
                Text(text = "Elevated")
            }
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Email, contentDescription = "Favorite")
            }
        }
        FloatingActionButton(onClick = { }) {
            Icon(Icons.Filled.Call, contentDescription = "")

        }

        Card(
            modifier = Modifier
                .padding(8.dp)
                .size(width = 200.dp, height = 150.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {
            Text(
                text = "I am a Card",
                modifier = Modifier.padding(55.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            AssistChip(
                onClick = { },
                label = { Text("Assist Chip") }
            )
            SuggestionChip(
                onClick = { Log.d("Suggestion chip", "hello world") },
                label = { Text("Suggestion chip") }
            )
        }

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            thickness = 5.dp,
            color = Color.Blue
        )
        SliderDemo()

            var checked by remember { mutableStateOf(true) }
            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            )
Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
    CircularProgressIndicator(
        progress = { .8f }
    )
    CircularProgressIndicator()
}
        Column(verticalArrangement = Arrangement.spacedBy(40.dp)){
            LinearProgressIndicator(
                progress = { .6f },
            )
            LinearProgressIndicator()
        }
    }
}

@Composable
fun SliderDemo() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun LoginScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Jetpack Compose",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(R.drawable.jetpack_compose_logo),
                    contentDescription = "Jetpack Compose",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )




                Spacer(modifier = Modifier.height(16.dp))
                Row (){
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF388E3C),
                        fontSize = 20.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                var email by remember { mutableStateOf("") }
                var password by remember { mutableStateOf("") }
                var passwordVisible by remember { mutableStateOf(false) }

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email ID or Mobile Number") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val image = if (passwordVisible) {
                            painterResource(id = R.drawable.ic_visibility)
                        } else {
                            painterResource(id = R.drawable.ic_visibility_off)
                        }

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(painter = image, contentDescription = null)
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(
                    onClick = { /* TODO: Implement forgot password logic */ },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Forgot Password?", color = Color(0xFF388E3C))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO: Implement login logic */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Login")
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Don't have an account? Register",
            modifier = Modifier.clickable(onClick = { /* TODO: Implement register logic */ }),
            color = Color(0xFF388E3C)
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var text by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(title = { Text("UI Elements Demo") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("FAB Clicked")
                }
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { showDialog = true }) {
                Text("Show Dialog")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { showBottomSheet = true }) {
                Text("Show Bottom Sheet")
            }
            Spacer(modifier = Modifier.height(16.dp))
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, MaterialTheme.colorScheme.primary)
                    .padding(8.dp)
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Dialog Title") },
            text = { Text("This is a dialog message.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            dismissButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showBottomSheet) {
        BottomSheet(
            onDismissRequest = { showBottomSheet = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismissRequest: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.5f))
            .clickable(onClick = onDismissRequest)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(16.dp)
        ) {
            Text("This is a Bottom Sheet")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onDismissRequest) {
                Text("Hide Bottom Sheet")
            }
        }
    }
}

@Composable
fun UIElementsDemoTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}
@Composable
fun examplescreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Homescreen(navController) }
        composable("about") { AboutScreen() }
        composable("contact") { ContactScreen() }
    }
}

@Composable
fun Listexample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { Homescreen(navController) }
        composable("list") { SimpleList() }
        composable("grid") { SimpleGrid() }
    }
}

@Composable
fun Homescreen(navController: NavController) {
    Column {
        Text(text = "Home Screen")
        Button(onClick = { navController.navigate("list") }) {
            Text("Go to List")
        }
        Button(onClick = { navController.navigate("grid") }) {
            Text("Go to Grid")
        }
    }
}

@Composable
fun SimpleList() {
    val itemsList = remember { List(100) { "Item #$it" } }
    LazyColumn {
        items(itemsList.size) { item ->
            Text(text = itemsList[item])
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SimpleGrid() {
    val itemsList = remember { List(100) { "Item #$it" } }
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(itemsList.size) { index ->
            Text(text = itemsList[index])
        }
    }
}
