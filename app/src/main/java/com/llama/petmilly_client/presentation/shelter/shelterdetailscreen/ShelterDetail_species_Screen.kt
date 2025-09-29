package com.llama.petmilly_client.presentation.shelter.shelterdetailscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.llama.petmilly_client.presentation.common.compnent.TitleBarComponent
import com.llama.petmilly_client.presentation.dialog.SetAlomostCompletedDialog
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.ButtonShapeScreen
import com.llama.petmilly_client.utils.CheckedCheckBox
import com.llama.petmilly_client.utils.NoneCheckBox
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular
import llama.test.jetpack_dagger_plz.utils.Common

@Composable
fun ShelterDetail_species_Screen(
    navController: NavController,
    viewModel: ShelterDetailViewModel,
    activity: ShelterDetailActivity,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TitleBarComponent(
            title = "임보처구해요",
            isMenu = false,
            onClickBack = { activity.finish() },
            onClickMenu = { viewModel.onShownAlmostCompetedDialog() }
        )

        ShelterDetailSuvTitle("주인공의 정보를\n입력해주세요.")

        Spacer(modifier = Modifier.height(50.dp))

        ShelterBtn(species = "강아지", viewModel)


        Spacer(modifier = Modifier.height(16.dp))

        ShelterBtn(species = "고양이", viewModel)

        Spacer(modifier = Modifier.weight(1f))

        ButtonScreen(
            title = "다음",
            textcolor = Color.White,
            fontSize = 15,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(55.dp),
            backgroundcolor = if (viewModel.species.value != "") Button_Clicked else Button_NoneClicked
        ) {
            navController.navigate(Common.SHELTERDETAIL_1_PROFILE_SCREEN)
        }


        SetAlomostCompletedDialog(
            viewModel.isAlmostCompletedDialog, onDismiss = {
                viewModel.onDismissAlmostCompetedDialog()
            },
            activity = activity
        )
    }//Column

}


@Composable
fun ShelterBtn(species: String, viewModel: ShelterDetailViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp, end = 50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (viewModel.species.value == species) {
            CheckedCheckBox(clickcolor = Category_Cliked)
        } else {
            NoneCheckBox(nonecheckcolor = Color.White)
        }

        ButtonShapeScreen(
            title = species,
            textcolor = if (viewModel.species.value == species) Color.White else Color.Black,
            fontSize = 15,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            backgroundcolor = if (viewModel.species.value == species) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = if (viewModel.pickup.value == species) notosans_bold else notosans_regular
        ) {
            viewModel.species.value = species
        }

    }//LibraryDetailDTO
}
