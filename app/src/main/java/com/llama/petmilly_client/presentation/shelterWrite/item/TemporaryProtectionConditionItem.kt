package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.SpacerWidth
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun TemporaryProtectionCondition(
    yesOrNo: Boolean,
    text: String,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = if (yesOrNo) "✅ " else "❌ ")

        Text(
            text = text,
            fontFamily = notosans_regular,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Black_60_Transfer,
            maxLines = 1,
        )

        SpacerWidth(dp = 5.dp)

        Image(
            painter = painterResource(id = R.drawable.img_test_dog4),
            contentDescription = null,
            modifier = Modifier
                .size(15.dp)
                .clickable {
                    onDelete()
                },
            contentScale = ContentScale.Crop
        )
    }
}