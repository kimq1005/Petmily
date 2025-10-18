package com.llama.petmilly_client.presentation.common.compnent

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
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
fun TitleBarComponent(
    modifier: Modifier = Modifier,
    title: String,
    isMenu: Boolean = false,
    onClickBack: () -> Unit = {},
    onClickMenu: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp),
    ) {
        Image(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    onClickBack()
                }
        )

        Text(
            text = title,
            fontSize = 17.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            ),
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center),
        )

        AnimatedVisibility(
            visible = isMenu,
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        onClickMenu()
                    },
                )
        }
    }
}

@Preview
@Composable
private fun PreviewTitleBarComponent() {
    TitleBarComponent(
        title = "우리아이 찾아요",
        isMenu = true,
        onClickBack = {},
        onClickMenu = {}
    )
}