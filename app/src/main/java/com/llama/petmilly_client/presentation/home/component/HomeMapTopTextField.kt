package com.llama.petmilly_client.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor

@Composable
fun HomeMapTopTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onBtnClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .weight(8f)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,
            ),
            placeholder = {
                Text(text = "정보를 검색해보세요.")
            },
        )

        Spacer(modifier = Modifier.width(5.dp))

        Button(
            onClick = {
                onBtnClick()
            },
            modifier = Modifier
                .weight(1.5f)
                .width(55.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp)

        ) {
            Image(
                painter = rememberVectorPainter(Icons.Default.Search),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PreviewHomeMapTopTextField() {
    HomeMapTopTextField(
        value = "",
        onValueChange = {},
        onBtnClick = {},
    )
}