package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen

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
    petCategoryType: PetCategoryType,
    onCheckSpecies: (PetCategoryType) -> Unit,
    onNavigate: () -> Unit,
) {
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

        ShelterWriteBtnComponent(
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(start = 35.dp, end = 50.dp),
            species = PetCategoryType.PUPPY,
            isCheck = petCategoryType == PetCategoryType.PUPPY,
            onCheckSpecies = onCheckSpecies
        )

        ShelterWriteBtnComponent(
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(start = 35.dp, end = 50.dp),
            species = PetCategoryType.CAT,
            isCheck = petCategoryType == PetCategoryType.CAT,
            onCheckSpecies = onCheckSpecies
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = stringResource(R.string.next),
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (petCategoryType != PetCategoryType.ENTITY) Button_Clicked else Button_NoneClicked
        ) {
            if (petCategoryType != PetCategoryType.ENTITY)  onNavigate()
        }
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