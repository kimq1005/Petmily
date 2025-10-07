package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteNeuteredItem
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteVaccinationItem
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWriteProfileLastSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteProfileLastScreen(
        neuteringType = state.neuteredType,
        vaccinationType = state.vaccinationType,
        onSetNeuteringType = viewModel::setNeuteredType,
        onSetVaccinationType = viewModel::setVaccinationType,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteProfileLastScreen(
    neuteringType: NeuteringType?,
    vaccinationType: VaccinationType?,
    onSetNeuteringType: (NeuteringType?) -> Unit,
    onSetVaccinationType: (VaccinationType?) -> Unit,
    onNavigate: () -> Unit,
) {
    val isCheck by remember(vaccinationType, neuteringType) {
        derivedStateOf { vaccinationType != null && neuteringType != null }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_pet_profile_last_title)
        )

        ShelterWriteNeuteredItem(
            modifier = Modifier
                .padding(top = 28.dp),
            neuteringType = neuteringType,
            onSetNeuteringType = onSetNeuteringType
        )

        ShelterWriteVaccinationItem(
            modifier = Modifier
                .padding(top = 65.dp),
            vaccinationType = vaccinationType,
            onSetVaccinationType = onSetVaccinationType
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            ButtonScreen(
                title = "다음",
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (isCheck) Color.Black else Color.LightGray

            ) {
                if (isCheck) onNavigate()
            }

            Text(
                text = "3/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (isCheck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )
        }
    }
}
