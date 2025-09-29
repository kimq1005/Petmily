package com.llama.petmilly_client.presentation.shelter

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.llama.petmilly_client.R
import com.llama.petmilly_client.domain.model.shelter.TemporaryAddressInfo
import com.llama.petmilly_client.domain.model.shelter.TemporaryCompleteUser
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail
import com.llama.petmilly_client.domain.model.shelter.TemporaryUser
import com.llama.petmilly_client.presentation.dialog.AdoptionCompletedDialog
import com.llama.petmilly_client.presentation.shelter.component.shelterDetail.ShelterDetailInfoComponent
import com.llama.petmilly_client.presentation.shelter.item.ShelterDetailAdoptionInfoItem
import com.llama.petmilly_client.presentation.shelter.item.ShelterDetailPeriodItem
import com.llama.petmilly_client.presentation.shelter.item.ShelterDetailProfileItem

@Composable
fun ShelterDetailSuccessScreen(
    modifier: Modifier = Modifier,
    viewModel: ShelterDetailViewModel = hiltViewModel(),
    id: Int,
) {
    LaunchedEffect(Unit) {
        viewModel.initData(id)
    }

    val state = viewModel.container.stateFlow.collectAsState().value

    state.temporaryDetail?.let {
        ShelterDetailScreen(
            temporaryDetail = state.temporaryDetail,
            onAdoptionClick = viewModel::postAdoption
        )
    }
}

@Composable
private fun ShelterDetailScreen(
    temporaryDetail: TemporaryDetail,
    onAdoptionClick: () -> Unit,
) {
    val scrollState = rememberScrollState()
    var isAdoptionDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            ShelterDetailInfoComponent(
                modifier = Modifier
                    .padding(20.dp),
                temporaryDetail = temporaryDetail
            )

            ShelterDetailProfileItem(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp),
                temporaryDetail = temporaryDetail
            )


            if (!temporaryDetail.isComplete) {
                ShelterDetailPeriodItem(
                    modifier = Modifier
                        .padding(top = 16.dp)
                )

                ShelterDetailAdoptionInfoItem(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp),
                    temporaryDetail = temporaryDetail
                )
            }
        }

        if (!temporaryDetail.isComplete) {
            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp, end = 15.dp)
                    .size(55.dp)
                    .clickable {
                        isAdoptionDialog = true
                    }
            )
        }

        if (isAdoptionDialog) {
            AdoptionCompletedDialog(
                onDismiss = {
                    isAdoptionDialog = false
                },
                onConfirm = onAdoptionClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterDetailScreen() {
    ShelterDetailScreen(
        temporaryDetail = TemporaryDetail(
            protectionCondition = listOf(),
            protectionHope = listOf(),
            protectionNo = listOf(),
            addressInfo = TemporaryAddressInfo(
                id = 4979,
                longName = "Cary Snow",
                shortName = "Lindsey Robinson"
            ),
            age = 4.5,
            animalTypes = "hinc",
            breed = "appetere",
            character = "sententiae",
            charmAppeal = "platonem",
            completeUser = TemporaryCompleteUser(id = 6615),
            createdAt = "ex",
            gender = "eripuit",
            health = "dolores",
            id = 9009,
            inoculation = "electram",
            isComplete = false,
            isReceipt = false,
            name = "Tracy Burt",
            neutered = "alia",
            photoUrls = listOf(),
            pickUp = "eirmod",
            receptionPeriod = "sumo",
            skill = "habeo",
            thumbnail = null,
            user = TemporaryUser(id = 3313),
            weight = 2984
        ), onAdoptionClick = {}
    )
}