package com.llama.petmilly_client.presentation.shelterWrite.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.presentation.home.model.PetCategoryType
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.ButtonShapeScreen
import com.llama.petmilly_client.utils.CheckedCheckBox
import com.llama.petmilly_client.utils.NoneCheckBox
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWriteBtnComponent(
    modifier: Modifier = Modifier,
    species: PetCategoryType,
    isCheck: Boolean,
    onCheckSpecies: (PetCategoryType) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isCheck) {
            CheckedCheckBox(clickcolor = Category_Cliked)
        } else {
            NoneCheckBox(nonecheckcolor = Color.White)
        }

        ButtonShapeScreen(
            title = species.title,
            textcolor = if (isCheck) Color.White else Color.Black,
            fontSize = 15,
            modifier = Modifier
                .padding(start = 10.dp)
                .height(55.dp)
                .fillMaxWidth(),
            backgroundcolor = if (isCheck) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Start,
            fontFamily = if (isCheck) notosans_bold else notosans_regular
        ) {
            onCheckSpecies(species)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteBtnComponent() {
    ShelterWriteBtnComponent(
        species = PetCategoryType.CAT,
        isCheck = false,
        onCheckSpecies = {}
    )
}