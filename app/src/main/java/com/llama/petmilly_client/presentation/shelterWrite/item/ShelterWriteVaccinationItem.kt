package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.model.VaccinationType
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.CommonCategoryButtonComponent
import com.llama.petmilly_client.utils.UnKnownCheckBoxComponent
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWriteVaccinationItem(
    modifier: Modifier = Modifier,
    vaccinationType: VaccinationType?,
    onSetVaccinationType: (VaccinationType?) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.shelter_write_pet_profile_third_second_question_title),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            VaccinationType.values().forEach { item ->
                if (item != VaccinationType.UNKNOWN) {
                    CommonCategoryButtonComponent(
                        title = item.title,
                        textColor = if (vaccinationType == item) Color.White else Color.Black,
                        fontSize = 20,
                        modifier = Modifier
                            .weight(1f)
                            .padding(5.dp)
                            .height(100.dp),
                        backgroundColor = if (vaccinationType == item) Category_Cliked else Button_NoneClicked,
                        shape = RoundedCornerShape(19.dp),
                        textAlign = TextAlign.Center,
                        enabled = vaccinationType != VaccinationType.UNKNOWN,
                    ) {
                        onSetVaccinationType(item)
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 27.dp, top = 10.dp)
        ) {
            UnKnownCheckBoxComponent(
                onclick = { string ->
                    if (string.isNotEmpty())
                        onSetVaccinationType(VaccinationType.UNKNOWN)
                    else
                        onSetVaccinationType(null)
                }
            )

            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = VaccinationType.UNKNOWN.title,
                fontSize = 12.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteVaccinationItem() {
    ShelterWriteVaccinationItem(
        vaccinationType = VaccinationType.UN_VACCINATED,
        onSetVaccinationType = {}
    )
}