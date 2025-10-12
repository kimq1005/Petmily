package com.llama.petmilly_client.presentation.common.compnent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun BottomBtnComponent(
    modifier: Modifier = Modifier,
    title: String,
    page: String = "",
    isCheck: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            onClick = { if (isCheck) onClick() },
            colors = ButtonDefaults.buttonColors(backgroundColor = if (isCheck) Color.Black else Color.LightGray),
            shape = RoundedCornerShape(6.dp)

        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 15.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )
        }

        if (page.isNotEmpty()) {
            Text(
                text = page,
                fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewBottomBtnComponent() {
    BottomBtnComponent(
        title = "다음",
        page = "2/8",
        isCheck = true,
        onClick = {}
    )
}