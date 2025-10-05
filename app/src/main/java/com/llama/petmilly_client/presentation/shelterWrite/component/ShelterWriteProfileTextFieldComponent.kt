package com.llama.petmilly_client.presentation.shelterWrite.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor

@Composable
fun ShelterWriteProfileTextFieldComponent(
    modifier: Modifier = Modifier,
    value: String,
    onValue: (String) -> Unit,
    hint: String,
    enable: Boolean = true,
    keyboardOption: KeyboardOptions = KeyboardOptions.Default,
) {
    TextField(
        value = value,
        onValueChange = onValue,
        modifier = modifier
            .height(55.dp),
        shape = RoundedCornerShape(10.dp),
        enabled = enable,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = TextField_BackgroudColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.White,
            cursorColor = Color.Black,
        ),
        keyboardOptions = keyboardOption,
        placeholder = { Text(text = hint) }
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteProfileTextFieldComponent() {
    ShelterWriteProfileTextFieldComponent(
        value = "",
        onValue = {},
        hint = "hint",
        enable = true
    )
}