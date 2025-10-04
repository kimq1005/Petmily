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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.utils.ButtonScreen
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterWritePetInfoSuccessScreen(
    viewModel: ShelterWriteViewModel,
    navController: NavController,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWritePetInfoScreen(
        navController = navController,
        petCategoryType = state.petCategoryType,
        onCheckSpecies = viewModel::setPetSpecies
    )
}

@Composable
private fun ShelterWritePetInfoScreen(
    navController: NavController,
    petCategoryType: PetCategoryType,
    onCheckSpecies: (PetCategoryType) -> Unit,
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
            if (petCategoryType != PetCategoryType.ENTITY) navController.navigate(Common.SHELTERDETAIL_1_PROFILE_SCREEN)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWritePetInfoScreen() {
    val navController = rememberNavController()
    ShelterWritePetInfoScreen(
        navController = navController,
        petCategoryType = PetCategoryType.CAT,
        onCheckSpecies = {}
    )
}