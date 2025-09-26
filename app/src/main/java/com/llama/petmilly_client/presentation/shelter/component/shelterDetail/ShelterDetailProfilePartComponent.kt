package com.llama.petmilly_client.presentation.shelter.component.shelterDetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterDetailProfilePartComponent(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            color = Black_60_Transfer,
            fontSize = 13.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            modifier = Modifier.width(80.dp)
        )

        Text(
            text = content,
            color = Black_60_Transfer,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 15.dp),
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterDetailProfilePartComponent() {
    ShelterDetailProfilePartComponent(
        title = "중성화/접종",
        content = "모르겠어요/모르겠어요"
    )
}