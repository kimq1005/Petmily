package com.llama.petmilly_client.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.petmilly_client.presentation.home.ClusterManager.setClustering
import com.llama.petmilly_client.presentation.home.component.HomeMapTopTextField
import com.llama.petmilly_client.presentation.home.model.ClusterItem
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapEffect
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import ted.gun0912.clustering.naver.TedNaverClustering

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun HomeMapScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    var tedCluster: TedNaverClustering<ClusterItem>? by remember { mutableStateOf(null) }
    val context = LocalContext.current
    val state = viewModel.container.stateFlow.collectAsState()

    Box {
        val seoul = LatLng(37.532600, 127.024612)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition(seoul, 11.0)
        }

        NaverMap(
            modifier = Modifier
                .fillMaxSize(),
            cameraPositionState = cameraPositionState,
            content = {
                MapEffect { map ->
                    state.value.petData.let { data ->
                       val cluster =  setClustering(
                            context = context,
                            list = data,
                            naverMap = map,
                            onCategoryClick = {}
                        )

                        tedCluster = cluster
                    }
                }
            }
        )

        HomeMapTopTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 30.dp),
            value = "",
            onValueChange = {},
            onBtnClick = {}
        )

//            viewModel.setcategory()

//            if (viewModel.categorytest.size > 5) {
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 16.dp, top = 10.dp)
//                ) {
//                    items(viewModel.categorytest.subList(0, 3)) { item ->
//                        CategoryItems(categoryTest = item, selected = checkBoolean) {
////                           viewModel.checklibrary()
//                            tedNaverClustering?.clearItems()
//                        }
//
//                        Spacer(modifier = Modifier.width(8.dp))
//
//                    }
//                }
//
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 16.dp, top = 10.dp)
//                ) {
//                    items(
//                        viewModel.categorytest.subList(
//                            3,
//                            viewModel.categorytest.lastIndex
//                        )
//                    ) { item ->
//                        CategoryItems(categoryTest = item, selected = viewModel.selelctedcategory.value==item.title) {
//                            viewModel.selelctedcategory.value = ""
//                            viewModel.getlibrary()
//                            viewModel.selelctedcategory.value = item.title
//                        }
//                        Spacer(modifier = Modifier.width(8.dp))
//                                //커밋테스트
//                    }
//                    //
//                    //
//                }
//            } else {
//                LazyRow(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(12.dp),
//                    ) {
//                    viewModel.setcategory()
//
//                    items(viewModel.categorytest) { categorylist ->
//
//                        CategoryItems(categoryTest = categorylist, selected = checkBoolean,onClick = {
//                            //여기서 api요청을 하고 마커를 다시 그려줘야함 근데 NaverItesmSet은 Composable 객체여서 불가능함
//                        })
//
//                    }
//                }
//            }
//        }
//    }
    }
}