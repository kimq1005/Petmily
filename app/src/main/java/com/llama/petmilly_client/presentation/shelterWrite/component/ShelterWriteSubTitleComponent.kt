package com.llama.petmilly_client.presentation.shelterWrite.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWriteSubTitleComponent(
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .width(44.dp)
                    .height(44.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = stringResource(id = R.string.sheltersuvtitle),
                fontSize = 13.sp,
                color = Color.Black,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }

        Text(
            text = text,
            modifier = Modifier.
                padding(top = 35.dp),
            fontSize = 30.sp,
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

@Preview(showBackground = true)
@Composable
private fun ShelterWriteSubTitleWrite() {
    ShelterWriteSubTitleComponent(
        text = "타이틀"
    )
}