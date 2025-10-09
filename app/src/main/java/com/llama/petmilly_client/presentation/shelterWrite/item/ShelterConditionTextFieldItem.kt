package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteProfileTextFieldComponent
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterConditionTextFieldItem(
    title: String,
    hint: String,
    modifier: Modifier = Modifier,
    value: String,
    valueList: List<String>,
    onValue: (String) -> Unit,
    onSetValue: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 65.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(
            Modifier
                .padding(top = 6.dp)
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
        ) {
            ShelterWriteProfileTextFieldComponent(
                modifier = Modifier
                    .height(55.dp),
                value = value,
                onValue = onValue,
                hint = hint,
            )

            Image(
                painter = painterResource(id = R.drawable.img_test_dog4),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .height(45.dp)
                    .width(45.dp)
                    .clickable {
                        if (value.isNotEmpty()) {
                            onSetValue(value)
                            onValue("")
                        }
                    }
                    .padding(bottom = 9.dp),
                contentScale = ContentScale.Crop,
            )
        }

        valueList.forEach { item ->
            TemporaryProtectionCondition(
                modifier = Modifier
                    .padding(horizontal = 28.dp),
                yesOrNo = true,
                text = item,
                onDelete = { onSetValue(item) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterConditionTextFieldItem() {
    ShelterConditionTextFieldItem(
        title = "임보조건",
        hint = "예) 2주에1회 병원 통원 가능하신 분",
        value = "",
        valueList = listOf("그럼요", "당연하죠", "네네칙힌"),
        onValue = {},
        onSetValue = {},
    )
}