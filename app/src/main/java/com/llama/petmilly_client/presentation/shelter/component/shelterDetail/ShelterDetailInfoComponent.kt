package com.llama.petmilly_client.presentation.shelter.component.shelterDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.domain.model.shelter.TemporaryAddressInfo
import com.llama.petmilly_client.domain.model.shelter.TemporaryCompleteUser
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail
import com.llama.petmilly_client.domain.model.shelter.TemporaryUser
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.ui.theme.Name_Speech_Bubble
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterDetailInfoComponent(
    modifier: Modifier = Modifier,
    temporaryDetail: TemporaryDetail,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box {
            Image(
                painter = if (temporaryDetail.thumbnail?.photoUrl != "") rememberAsyncImagePainter(
                    model = temporaryDetail.thumbnail?.photoUrl
                ) else
                    painterResource(id = R.drawable.mainicon_png),
                contentDescription = null,
                modifier = Modifier
                    .size(127.dp)
                    .background(color = Color.Blue)
                    .align(Alignment.CenterStart),
                contentScale = ContentScale.Crop
            )

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .size(31.dp)
                    .align(Alignment.TopStart)
                    .padding(start = 8.dp, top = 8.dp),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .height(130.dp)
                .padding(start = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = "\uD83D\uDC49 ${temporaryDetail.charmAppeal}",
                    modifier = Modifier
                        .background(
                            color = Name_Speech_Bubble,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(vertical = 5.dp, horizontal = 8.dp),
                    fontSize = 12.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = temporaryDetail.name,
                    fontSize = 16.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black
                )

                SpacerWidth(dp = 5.dp)

                Text(
                    text = temporaryDetail.gender,
                    fontSize = 13.sp,
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                    modifier = Modifier.align(Alignment.Bottom)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "${temporaryDetail.breed} / ${temporaryDetail.weight}/ ${temporaryDetail.age}}",
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                modifier = Modifier.background(color = Background_FDFCE1),
                color = Black_60_Transfer,
                fontSize = 13.sp
            )

            Row {
                Text(
                    text = "현재위치지역",
                    fontFamily = notosans_regular,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    color = Black_60_Transfer,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Text(
                    text = " ${temporaryDetail.addressInfo.shortName}",
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    fontSize = 13.sp,
                    color = Black_60_Transfer,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterDetailInfoComponent() {
    ShelterDetailInfoComponent(
        modifier =Modifier
            .fillMaxWidth()
        ,
        temporaryDetail = TemporaryDetail(
            protectionCondition = listOf(),
            protectionHope = listOf(),
            protectionNo = listOf(),
            addressInfo = TemporaryAddressInfo(
                id = 6952,
                longName = "Juanita Morris",
                shortName = "어딜까요"
            ),
            age = 4.5,
            animalTypes = "fusce",
            breed = "gravida",
            character = "nullam",
            charmAppeal = "강아지",
            completeUser = TemporaryCompleteUser(id = 8034),
            createdAt = "inciderint",
            gender = "수컷",
            health = "ad",
            id = 5891,
            inoculation = "idque",
            isComplete = false,
            isReceipt = false,
            name = "콩순이",
            neutered = "suspendisse",
            photoUrls = listOf(),
            pickUp = "cetero",
            receptionPeriod = "laudem",
            skill = "pri",
            thumbnail = null,
            user = TemporaryUser(id = 3994),
            weight = 2037
        )
    )
}