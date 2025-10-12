package com.llama.petmilly_client.presentation.shelterWrite.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.ui.theme.Grey_100_CBC4C4
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWritePeriodTextFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onValue: (String) -> Unit,
) {
    TextField(
        value = value,
        modifier = modifier,
        onValueChange = {
            onValue(it)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(
            fontSize = 30.sp, fontFamily = notosans_bold,
            platformStyle = PlatformTextStyle(
                includeFontPadding = false
            )
        ),
        placeholder = {
            Text(
                text = hint,
                fontSize = 30.sp,
                fontFamily = notosans_bold,
                color = Grey_100_CBC4C4,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }
    )
}