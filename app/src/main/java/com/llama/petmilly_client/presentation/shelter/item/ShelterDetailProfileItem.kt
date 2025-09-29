package com.llama.petmilly_client.presentation.shelter.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.domain.model.shelter.TemporaryAddressInfo
import com.llama.petmilly_client.domain.model.shelter.TemporaryCompleteUser
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail
import com.llama.petmilly_client.domain.model.shelter.TemporaryUser
import com.llama.petmilly_client.presentation.shelter.component.shelterDetail.ShelterDetailProfilePartComponent
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterDetailProfileItem(
    modifier: Modifier = Modifier,
    temporaryDetail: TemporaryDetail,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.shelter_profile_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp),
            fontSize = 16.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            color = Color.Black,
        )

        (0..3).forEach { i ->

            val title = when (i) {
                0 -> stringResource(R.string.shelter_profile_question_1)
                1 -> stringResource(R.string.shelter_profile_question_2)
                2 -> stringResource(R.string.shelter_profile_question_3)
                3 -> stringResource(R.string.shelter_profile_question_4)
                else -> ""
            }

            val content = when (i) {
                0 -> "${temporaryDetail.neutered} / ${temporaryDetail.inoculation}"
                1 -> temporaryDetail.health
                2 -> temporaryDetail.skill
                3 -> temporaryDetail.character
                else -> ""
            }

            ShelterDetailProfilePartComponent(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(vertical = 10.dp),
                title = title,
                content = content
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth(),
                color = Color.LightGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterDetailProfileItem() {
    ShelterDetailProfileItem(
        temporaryDetail = TemporaryDetail(
            protectionCondition = listOf(),
            protectionHope = listOf(),
            protectionNo = listOf(),
            addressInfo = TemporaryAddressInfo(
                id = 6661,
                longName = "Lyle West",
                shortName = "Hope Owen"
            ),
            age = 0.1,
            animalTypes = "scelerisque",
            breed = "doming",
            character = "volumus",
            charmAppeal = "fringilla",
            completeUser = TemporaryCompleteUser(id = 4022),
            createdAt = "tristique",
            gender = "ligula",
            health = "posse",
            id = 3804,
            inoculation = "odio",
            isComplete = false,
            isReceipt = false,
            name = "Basil Fletcher",
            neutered = "indoctum",
            photoUrls = listOf(),
            pickUp = "venenatis",
            receptionPeriod = "audire",
            skill = "quisque",
            thumbnail = null,
            user = TemporaryUser(id = 4207),
            weight = 5879
        )
    )
}