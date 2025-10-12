package com.llama.petmilly_client.presentation.shelterWrite.item

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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWritePeriodCautionItem(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(85.dp)
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
                text = "* 임보/입양신청서 접수기간 설정 시",
                fontSize = 13.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
            )

            Text(
                text = " 해당 기간 내 신청서 접수 받을 수 있으며,",
                fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black
            )

            Text(
                text = " 작성자분의 심사를 통해 선별할 수 있습니다.",
                fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWritePeriodCautionItem() {
    ShelterWritePeriodCautionItem()
}