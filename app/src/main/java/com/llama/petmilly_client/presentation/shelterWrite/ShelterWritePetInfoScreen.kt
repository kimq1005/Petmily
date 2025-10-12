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
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteCategoryBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent

@Composable
fun ShelterWritePetInfoSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWritePetInfoScreen(
        petCategoryType = state.petCategoryType,
        onCheckSpecies = viewModel::setPetSpecies,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWritePetInfoScreen(
    petCategoryType: PetCategoryType?,
    onCheckSpecies: (PetCategoryType) -> Unit,
    onNavigate: () -> Unit,
) {
    val isCheck by remember(petCategoryType) {
        derivedStateOf {
            petCategoryType != null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_pet_info_title)
        )

        ShelterWriteCategoryBtnComponent(
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(start = 35.dp, end = 50.dp),
            species = PetCategoryType.PUPPY,
            isCheck = petCategoryType == PetCategoryType.PUPPY,
            onCheckSpecies = onCheckSpecies
        )

        ShelterWriteCategoryBtnComponent(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(start = 35.dp, end = 50.dp),
            species = PetCategoryType.CAT,
            isCheck = petCategoryType == PetCategoryType.CAT,
            onCheckSpecies = onCheckSpecies
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            onClick = {
                onNavigate()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWritePetInfoScreen() {
    ShelterWritePetInfoScreen(
        petCategoryType = PetCategoryType.CAT,
        onCheckSpecies = {},
        onNavigate = {}
    )
}