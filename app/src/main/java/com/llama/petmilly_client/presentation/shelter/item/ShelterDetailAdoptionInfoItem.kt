package com.llama.petmilly_client.presentation.shelter.item

import androidx.compose.foundation.background
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
import com.llama.petmilly_client.ui.theme.Pink_5_Transfer
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterDetailAdoptionInfoItem(
    modifier: Modifier = Modifier,
    temporaryDetail: TemporaryDetail,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.shelter_detail_adoption_title),
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

        Column(
            modifier = Modifier
                .background(color = Pink_5_Transfer)
        ) {
            (0..3).forEach { i ->
                val title = when (i) {
                    0 -> stringResource(R.string.shelter_detail_adoption_question_1)
                    1 -> stringResource(R.string.shelter_detail_adoption_question_2)
                    2 -> stringResource(R.string.shelter_detail_adoption_question_3)
                    3 -> stringResource(R.string.shelter_detail_adoption_question_4)
                    else -> ""
                }

                val content = when (i) {
                    0 -> temporaryDetail.pickUp
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
                    content = content,
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color.LightGray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShelterDetailInfoItem() {
    ShelterDetailAdoptionInfoItem(
        temporaryDetail = TemporaryDetail(
            protectionCondition = listOf(),
            protectionHope = listOf(),
            protectionNo = listOf(),
            addressInfo = TemporaryAddressInfo(
                id = 7989,
                longName = "Ernesto Alston",
                shortName = "Jon Velazquez"
            ),
            age = 2.3,
            animalTypes = "quis",
            breed = "detraxit",
            character = "consequat",
            charmAppeal = "morbi",
            completeUser = TemporaryCompleteUser(id = 4035),
            createdAt = "mi",
            gender = "melius",
            health = "quod",
            id = 3561,
            inoculation = "repudiare",
            isComplete = false,
            isReceipt = false,
            name = "Kimberly Conley",
            neutered = "gloriatur",
            photoUrls = listOf(),
            pickUp = "ac",
            receptionPeriod = "cetero",
            skill = "aliquid",
            thumbnail = null,
            user = TemporaryUser(id = 5904),
            weight = 4467
        )
    )
}