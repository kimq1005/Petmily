package com.llama.petmilly_client.presentation.myProfile.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.myProfile.CircleView
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ProfileAdoptionStatusItem(
    modifier: Modifier = Modifier,
    adoptionCount: Int,
    temporaryProtectionCount: Int,
    moveServiceCount: Int,
) {
    Row(
        modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .weight(1.5f),
            color = Color.Black
        )

        Box(
            modifier = Modifier
                .weight(9f)
                .height(62.dp)
                .background(
                    color = Color(0xFFECF2FF),
                    shape = RoundedCornerShape(2.dp)
                ),
        ) {
            CircleView(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = (-3).dp),
                color = Color.Black,
            )

            Row(
                Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.adoption),
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "$adoptionCount 건",
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.temporary_protection),
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "$temporaryProtectionCount 건",
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.move_service),
                        fontFamily = notosans_bold,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "$moveServiceCount 건",
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 4.dp, end = 4.dp),
                contentScale = ContentScale.Crop
            )

            CircleView(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(x = 3.dp),
                color = Color.Black
            )
        }

        Divider(
            modifier = Modifier
                .weight(1.5f),
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun PreviewProfileAdoptionStatusItem() {
    ProfileAdoptionStatusItem(
        adoptionCount = 10,
        temporaryProtectionCount = 2,
        moveServiceCount = 0
    )
}