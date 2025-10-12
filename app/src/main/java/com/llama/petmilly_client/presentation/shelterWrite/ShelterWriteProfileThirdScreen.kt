package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.BottomBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteNeuteredItem
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteVaccinationItem
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType

@Composable
fun ShelterWriteProfileThirdSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteProfileThirdScreen(
        neuteringType = state.neuteredType,
        vaccinationType = state.vaccinationType,
        onSetNeuteringType = viewModel::setNeuteredType,
        onSetVaccinationType = viewModel::setVaccinationType,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteProfileThirdScreen(
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

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            page = "3/8",
            onClick = {
                if (isCheck) onNavigate()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteProfileThirdScreen() {
    ShelterWriteProfileThirdScreen(
        neuteringType = NeuteringType.NEUTERED,
        vaccinationType = null,
        onSetNeuteringType = {},
        onSetVaccinationType = {},
        onNavigate = {}
    )
}
