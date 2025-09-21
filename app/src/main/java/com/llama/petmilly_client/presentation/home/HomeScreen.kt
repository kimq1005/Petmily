package com.llama.petmilly_client.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//private val naverMap: NaverMap? = null

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("HomeScreen")
    }
//    NaverMapViewScreen()
}

@Preview
@Composable
fun MAPSCREENPREVIEW() {
    HomeScreen()
}



