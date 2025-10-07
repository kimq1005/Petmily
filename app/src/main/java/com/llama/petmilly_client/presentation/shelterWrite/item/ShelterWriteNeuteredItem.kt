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
import com.llama.petmilly_client.presentation.shelterWrite.model.NeuteringType
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.CommonCategoryButtonComponent
import com.llama.petmilly_client.utils.UnKnownCheckBoxComponent
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWriteNeuteredItem(
    modifier: Modifier = Modifier,
    neuteringType: NeuteringType?,
    onSetNeuteringType: (NeuteringType?) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.shelter_write_pet_profile_third_first_question_title),
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
            CommonCategoryButtonComponent(
                title = NeuteringType.NEUTERED.title,
                textColor = if (neuteringType == NeuteringType.NEUTERED) Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(70.dp),
                backgroundColor = if (neuteringType == NeuteringType.NEUTERED) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
            ) {
                onSetNeuteringType(NeuteringType.NEUTERED)
            }

            CommonCategoryButtonComponent(
                title = NeuteringType.UN_NEUTERED.title,
                textColor = if (neuteringType == NeuteringType.UN_NEUTERED) Color.White else Color.Black,
                fontSize = 20,
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .height(70.dp),
                backgroundColor = if (neuteringType == NeuteringType.UN_NEUTERED) Category_Cliked else Button_NoneClicked,
                shape = RoundedCornerShape(19.dp),
                textAlign = TextAlign.Center,
            ) {
                onSetNeuteringType(NeuteringType.UN_NEUTERED)
            }
        }

        Row(
            modifier = Modifier
                .padding(start = 27.dp, top = 10.dp)
        ) {
            UnKnownCheckBoxComponent(
                onclick = { string ->
                    if (string.isNotEmpty())
                        onSetNeuteringType(NeuteringType.UNKNOWN)
                    else
                        onSetNeuteringType(null)
                }
            )

            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = NeuteringType.UNKNOWN.title,
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
private fun PreviewShelterWriteNeuteredItem() {
    ShelterWriteNeuteredItem(
        neuteringType = NeuteringType.NEUTERED,
        onSetNeuteringType = {}
    )
}