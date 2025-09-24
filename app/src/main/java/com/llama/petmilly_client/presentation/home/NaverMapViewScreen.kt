package com.llama.petmilly_client.presentation.home

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.petmilly_client.domain.model.home.LibraryDetail
import com.llama.petmilly_client.presentation.adoptionscreen.AdoptionActivity
import com.llama.petmilly_client.presentation.findanimalscreen.FindAnimalActivity
import com.llama.petmilly_client.presentation.home.ClusterManager.setClustering
import com.llama.petmilly_client.presentation.home.component.HomeMapTopTextField
import com.llama.petmilly_client.presentation.home.items.PetCategoryItem
import com.llama.petmilly_client.presentation.home.items.ShelterCategoryItem
import com.llama.petmilly_client.presentation.home.model.ClusterItem
import com.llama.petmilly_client.presentation.home.model.HomeSideEffect
import com.llama.petmilly_client.presentation.home.model.PetCategory
import com.llama.petmilly_client.presentation.home.model.ShelterCategory
import com.llama.petmilly_client.presentation.moveservicscreen.MoveServiceActivity
import com.llama.petmilly_client.presentation.shelter.ShelterActivity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.NaverMap
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.MapEffect
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import org.orbitmvi.orbit.compose.collectSideEffect
import ted.gun0912.clustering.naver.TedNaverClustering

private var naverMap: NaverMap? = null

@Composable
fun HomeMapSuccessScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val context = LocalContext.current

    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is HomeSideEffect.Error -> {
                val errorMessage = sideEffect.message
                Log.e("TAG", "LoginSuccessScreen Error: $errorMessage")
            }

            is HomeSideEffect.NavigateToActivity -> {
                //Todo 아래 Activity삭제 후 NavHost로 변경예정
                when (sideEffect.shelterCategory) {
                    ShelterCategory.SAVE_SHELTER -> {
                        val intent = Intent(context, ShelterActivity::class.java)
                        context.startActivity(intent)
                    }

                    ShelterCategory.FIND_MY_BABY -> {
                        val intent = Intent(context, FindAnimalActivity::class.java)
                        context.startActivity(intent)
                    }

                    ShelterCategory.MOVE_VOLUNTEER -> {
                        val intent = Intent(context, MoveServiceActivity::class.java)
                        context.startActivity(intent)
                    }

                    ShelterCategory.ADOPTION_NOTICE -> {
                        val intent = Intent(context, AdoptionActivity::class.java)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }

    HomeMapScreen(
        petData = state.petData,
        selectedPetCategory = state.selectedPetCategory,
        selectedShelterCategory = state.selectedShelterCategory,
        onClickPetCategory = viewModel::onClickPetCategory,
        onClickShelterCategory = viewModel::onClickShelterCategory,
        onClusterClick = viewModel::onClusterClick
    )
}

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun HomeMapScreen(
    petData: List<LibraryDetail>,
    selectedPetCategory: List<PetCategory>,
    selectedShelterCategory: List<ShelterCategory>,
    onClickPetCategory: (PetCategory) -> Unit,
    onClickShelterCategory: (ShelterCategory) -> Unit,
    onClusterClick: () -> Unit,
) {
    var tedCluster: TedNaverClustering<ClusterItem>? by remember { mutableStateOf(null) }
    val context = LocalContext.current

    LaunchedEffect(petData) {
        naverMap?.let { map ->
            tedCluster?.clearItems()

            val cluster = setClustering(
                context = context,
                list = petData,
                naverMap = map,
                onClusterClick = onClusterClick
            )

            tedCluster = cluster

            //Todo: 카메라 이동 위치 변경
            map.moveCamera(CameraUpdate.scrollTo(LatLng(37.532600, 127.024612)))
        }
    }

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
                    naverMap = map
                }
            }
        )

        Column {
            HomeMapTopTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 30.dp),
                value = "",
                onValueChange = {},
                onBtnClick = {}
            )

            PetCategoryItem(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 10.dp),
                selectedPetCategory = selectedPetCategory,
                onClick = onClickPetCategory
            )

            ShelterCategoryItem(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 5.dp),
                selectedShelterCategory = selectedShelterCategory,
                onClick = onClickShelterCategory
            )
        }
    }
}
