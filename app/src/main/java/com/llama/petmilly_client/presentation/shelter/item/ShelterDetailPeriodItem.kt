package com.llama.petmilly_client.presentation.shelter.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterDetailPeriodItem(
    modifier: Modifier = Modifier,
    applicationPeriod: String = "",
    reviewPeriod: String = "",
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(color = Color(0xFFECF2FF)),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 25.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .width(50.dp)
                    .height(40.dp)
                    .align(Alignment.CenterStart)
            )

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = 20.dp)

            )
        }

        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .fillMaxHeight(), verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(
                    R.string.shelter_detail_application_period,
                    applicationPeriod
                ),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF3050F6),
                modifier = Modifier.padding(bottom = 5.dp)
            )
            Text(
                text = stringResource(R.string.shelter_detail_review_period, reviewPeriod),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = stringResource(R.string.shelter_detail_period_notification),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Black_60_Transfer,
                fontSize = 11.sp
            )
        }
    }
}

@Preview
@Composable
private fun PreviewShelterDetailPeriodItem() {
    ShelterDetailPeriodItem()
}