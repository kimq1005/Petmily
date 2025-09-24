package com.llama.petmilly_client.presentation.shelter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterLabelComponent(
    text: String,
    isComplete: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 8.sp,
        fontFamily = if (isComplete) notosans_regular else notosans_bold,
        style = TextStyle(
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = modifier
            .background(
                if (isComplete) Color.Black else Category_Cliked,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 5.dp, vertical = 4.dp)
    )
}

@Preview
@Composable
private fun PreviewShelterLabelComponent() {
    ShelterLabelComponent(
        text = "완료",
        isComplete = true
    )
}

