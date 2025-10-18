package com.llama.petmilly_client.presentation.myProfile.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun MyProfileInfoItem(
    modifier: Modifier = Modifier,
    title: String = "",
    caution: String,
    isCertification: Boolean,
    onClickProfile: () -> Unit
)
{
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_testcat_2),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(70.dp)
                .align(Alignment.CenterVertically),
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .clickable {
                        onClickProfile()
                    },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontFamily = notosans_bold,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    ),
                    color = Color.Black
                )

                SpacerWidth(dp = 10.dp)

                Image(
                    painter = painterResource(id = R.drawable.img_go),
                    contentDescription = null,
                    modifier = Modifier
                        .size(13.dp),
                )
            }

            if (isCertification) {
                Row(
                    modifier = Modifier
                        .padding(top = 3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.profile_town_certification),
                        color = Color.Black,
                        fontFamily = notosans_regular,
                        style = TextStyle(
                            platformStyle = PlatformTextStyle(
                                includeFontPadding = false
                            )
                        ),
                        fontSize = 13.sp
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img_checkcircle_green),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .size(18.dp)
                    )
                }
            }

            Text(
                text = caution,
                modifier = Modifier
                    .padding(top = 13.dp)
                    .background(
                        color = Color(0xFFF5F5F5),
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(horizontal = 7.dp, vertical = 3.dp),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.Black,
                fontSize = 10.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyProfileInfoItem() {
    MyProfileInfoItem(
        title = "쪼꼬",
        caution = "입양 수가 많으면 애니멀호더로 의심될 수 있습니다.",
        isCertification = true,
        onClickProfile = {}
    )
}