package com.example.demoapp
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Column

@Composable
fun HomeScreen(navController: NavController) {
    Column {
        Text(text = "Home Screen")
        Button(onClick = { navController.navigate("about") }) {
            Text("Go to About")
        }
        Button(onClick = { navController.navigate("contact") }) {
            Text("Go to Contact")
        }
    }
}
