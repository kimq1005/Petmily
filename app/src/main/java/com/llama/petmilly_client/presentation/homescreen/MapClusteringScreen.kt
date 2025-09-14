package com.llama.petmilly_client.presentation.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MapClusteringScreen(upPress: () -> Unit) {
    Scaffold(
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
//            NaverMapClustering()
        }
    }
}

//@Composable
//private fun NaverMapClustering() {
//    val items = remember { mutableStateListOf<MyItem>() }
//    LaunchedEffect(Unit) {
//
//        repeat(50) {
//            val position = ㅣㅁㅅ(
//                POSITION.latitude + Random.nextFloat(),
//                POSITION.longitude + Random.nextFloat(),
//            )
//            items.add(MyItem(position, "Marker", "Snippet"))
//        }
//
//        Log.d(TAG, "NaverMapClustering: ${items.get(0)}")
//
//    }
//    NaverMapClustering(items = items)
//}
//
//@OptIn(ExperimentalNaverMapApi::class)
//@Composable
//private fun NaverMapClustering(items: List<MyItem>) {
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition(POSITION, 6.0)
//    }
//    NaverMap(
//        modifier = Modifier.fillMaxSize(),
//        cameraPositionState = cameraPositionState
//    ) {
//        val context = LocalContext.current
//        var clusterManager by remember { mutableStateOf<TedNaverClustering<MyItem>?>(null) }
//        DisposableMapEffect(items) { map ->
//            if (clusterManager == null) {
//                clusterManager = TedNaverClustering.with<MyItem>(context, map).make()
//            }
//            clusterManager?.addItems(items)
//            onDispose {
//                clusterManager?.clearItems()
//            }
//        }
//    }
//}
//
//private data class MyItem(
//    val itemPosition: LatLng,
//    val itemTitle: String,
//    val itemSnippet: String,
//) : TedClusterItem {
//    override fun getTedLatLng(): TedLatLng {
//        return TedLatLng(
//            latitude = itemPosition.latitude,
//            longitude = itemPosition.longitude,
//        )
//    }
//}
//
//private val POSITION = LatLng(37.5666102, 126.9783881)
