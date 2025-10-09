package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType
import com.llama.petmilly_client.ui.theme.Button_NoneClicked
import com.llama.petmilly_client.ui.theme.Category_Cliked
import com.llama.petmilly_client.utils.CommonCategoryButtonComponent
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWritePickUpCategoryItem(
    modifier: Modifier = Modifier,
    pickUpType: PickUpType?,
    onPickUpType: (PickUpType) -> Unit
    
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "픽업방법",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            PickUpType.values().forEach { item ->
                CommonCategoryButtonComponent(
                    title = item.title,
                    textColor = if (pickUpType == item) Color.White else Color.Black,
                    fontSize = 20,
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                        .height(65.dp),
                    backgroundColor = if (pickUpType == item) Category_Cliked else Button_NoneClicked,
                    shape = RoundedCornerShape(19.dp),
                    textAlign = TextAlign.Center,
                    onclick = { onPickUpType(item) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWritePickUpCategoryItem() {
    ShelterWritePickUpCategoryItem(
        pickUpType = PickUpType.DIRECT_PICKUP,
        onPickUpType = {}
    )
}