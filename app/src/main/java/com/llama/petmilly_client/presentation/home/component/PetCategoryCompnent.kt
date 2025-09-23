package com.llama.petmilly_client.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Category_Cliked

@Composable
fun CategoryComponent(
    modifier: Modifier = Modifier,
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(20.dp))
            .background(
                color = if (isSelected) Category_Cliked else Color.White,
                shape = RoundedCornerShape(16.5.dp),
            )
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 13.sp,
            color = if (isSelected) Color.White else Color.Black,
            modifier = Modifier
                .selectable(
                    selected = isSelected,
                    onClick = { onClick() }
                )
                .padding(top = 7.dp, bottom = 7.dp, start = 12.dp, end = 12.dp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview("카테고리 선택 됐을때")
@Composable
private fun PreviewPetCategoryClick() {
    CategoryComponent(
        title = "강아지",
        isSelected = true,
        onClick = {}
    )
}

@Preview
@Composable
private fun PreviewPetCategoryComponent() {
    CategoryComponent(
        title = "강아지",
        isSelected = false,
        onClick = {}
    )
}