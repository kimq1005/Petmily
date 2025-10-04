package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.CommonCategoryButtonComponent

@Composable
fun ShelterWriteGenderTypeItem(
    modifier: Modifier = Modifier,
    isSelectedGender: GenderType?,
    onSelectedGender: (GenderType) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
            .padding(horizontal = 26.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CommonCategoryButtonComponent(
            title = GenderType.MALE.gender,
            textColor = if (isSelectedGender == GenderType.MALE) Color.White else Color.Black,
            fontSize = 20,
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
                .height(55.dp),
            backgroundColor = if (isSelectedGender == GenderType.MALE) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Center,
            enabled = true
        ) {
            onSelectedGender(GenderType.MALE)
        }

        CommonCategoryButtonComponent(
            title = GenderType.FEMALE.gender,
            textColor = if (isSelectedGender == GenderType.FEMALE) Color.White else Color.Black,
            fontSize = 20,
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
                .height(55.dp),
            backgroundColor = if (isSelectedGender == GenderType.FEMALE) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Center,
            enabled = true
        ) {
            onSelectedGender(GenderType.FEMALE)
        }

        CommonCategoryButtonComponent(
            title = GenderType.UNKNOWN.gender,
            textColor = if (isSelectedGender == GenderType.UNKNOWN) Color.White else Color.Black,
            fontSize = 20,
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
                .height(55.dp),
            backgroundColor = if (isSelectedGender == GenderType.UNKNOWN) Category_Cliked else Button_NoneClicked,
            shape = RoundedCornerShape(19.dp),
            textAlign = TextAlign.Center,
            enabled = true
        ) {
            onSelectedGender(GenderType.UNKNOWN)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterShelterWriteGenderTypeItem() {
    ShelterWriteGenderTypeItem(
        modifier = Modifier
            .fillMaxWidth(),
        isSelectedGender = GenderType.MALE,
        onSelectedGender = {}
    )
}