package com.llama.petmilly_client.presentation.shelter

import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.llama.petmilly_client.domain.model.shelter.PostDetail
import com.llama.petmilly_client.presentation.certificationscreen.CertificationActivity
import com.llama.petmilly_client.presentation.shelter.item.ShelterItem
import com.llama.petmilly_client.presentation.shelter.item.ShelterSafeCategoryItem
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeType
import com.llama.petmilly_client.presentation.shelter.model.ShelterSideEffect
import llama.test.jetpack_dagger_plz.utils.Common.TAG
import org.orbitmvi.orbit.compose.collectSideEffect

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SafeShelterSuccessScreen(
    viewModel: ShelterViewModel = hiltViewModel(),
    navController: NavController,
) {
    val context = LocalContext.current
    val state = viewModel.container.stateFlow.collectAsState().value

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            is ShelterSideEffect.Error -> Log.d(TAG, "SafeShelterSuccessScreen Error: ${sideEffect.message}")
            is ShelterSideEffect.NavigateToActivity -> {
                val intent = Intent(context, CertificationActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

    SafeShelterScreen(
        postDatList = state.postDataList,
        selectedCategory = state.selectedCategory,
        onItemClick = {
            navController.navigate(ShelterSafeType.ANIMAL_INFO_DETAIL.name + "/${it.id}")
        },
        onCategoryClick = viewModel::onCategoryClick,
        onFloatBtnClick = viewModel::onFloatBtnClick
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SafeShelterScreen(
    modifier: Modifier = Modifier,
    postDatList: List<PostDetail>,
    selectedCategory: List<ShelterSafeCategoryType>,
    onItemClick: (PostDetail) -> Unit,
    onCategoryClick: (ShelterSafeCategoryType) -> Unit,
    onFloatBtnClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ShelterSafeCategoryItem(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .padding(horizontal = 16.dp),
                selectedItem = selectedCategory,
                onClick = onCategoryClick
            )

            Spacer(modifier = Modifier.height(10.dp))

            ShelterItem(
                modifier = Modifier
                    .padding(horizontal = 7.dp),
                postDataList = postDatList,
                onClick = onItemClick
            )
        }

        Image(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 15.dp)
                .size(55.dp)
                .clickable {
                    onFloatBtnClick()
                }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PreviewSafeShelterScreen() {
    SafeShelterScreen(
        postDatList = listOf(
            PostDetail(
                age = 0.1,
                breed = "maiestatis",
                createdAt = "eu",
                gender = "veniam",
                id = 7269,
                inoculation = "efficitur",
                isComplete = false,
                isReceipt = false,
                name = "Tanisha Gentry",
                neutered = "convenire",
                thumbnail = null,
                weight = 6325
            )
        ),
        selectedCategory = emptyList(),
        onItemClick = {},
        onFloatBtnClick = {},
        onCategoryClick = {}
    )
}