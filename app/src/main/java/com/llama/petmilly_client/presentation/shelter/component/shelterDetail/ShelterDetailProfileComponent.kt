package com.llama.petmilly_client.presentation.shelter.component.shelterDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.SpacerHeight
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

class ShelterDetailProfileComponent {
}

@Composable
fun ShelterDetailProfileComponent(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "프로필", modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp),
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
                .padding(top = 5.dp, start = 20.dp, end = 20.dp), color = Color.Black
        )



        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            SpacerHeight(dp = 10.dp)

//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 10.dp, bottom = 10.dp)
//            ) {
//                Text(
//                    text = "중성화/접종 ",
//                    color = Black_60_Transfer,
//                    fontSize = 13.sp,
//                    fontFamily = notosans_bold,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    ),
//                    modifier = Modifier.width(80.dp)
//                )
//
//                Text(
//                    text = "${viewModel.neutered_detail.value} / ${viewModel.inoculation_detail.value} ",
//                    color = Black_60_Transfer,
//                    fontSize = 13.sp,
//                    modifier = Modifier.padding(start = 15.dp),
//                    fontFamily = notosans_regular,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    )
//                )
//            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), color = Color.LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "성격",
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    modifier = Modifier.width(80.dp)
                )

//                Text(
//                    text = viewModel.health_detail.value,
//                    fontFamily = notosans_regular,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    ),
//                    color = Black_60_Transfer,
//                    fontSize = 13.sp,
//                    modifier = Modifier.padding(start = 15.dp)
//                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), color = Color.LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "개인기",
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    modifier = Modifier.width(80.dp)
                )

//                Text(
//                    text = viewModel.skill_detail.value,
//                    fontFamily = notosans_regular,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    ),
//                    color = Black_60_Transfer,
//                    fontSize = 13.sp,
//                    modifier = Modifier.padding(start = 15.dp)
//                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp), color = Color.LightGray
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "성격 및 특징",
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Black_60_Transfer,
                    fontSize = 13.sp,
                    modifier = Modifier.width(80.dp)
                )

//                Text(
//                    text = viewModel.character_detail.value,
//                    fontFamily = notosans_regular,
//                    style = TextStyle(
//                        platformStyle = PlatformTextStyle(
//                            includeFontPadding = false
//                        )
//                    ),
//                    color = Black_60_Transfer,
//                    fontSize = 13.sp,
//                    modifier = Modifier.padding(start = 15.dp)
//                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterDetailProfileComponent() {

}