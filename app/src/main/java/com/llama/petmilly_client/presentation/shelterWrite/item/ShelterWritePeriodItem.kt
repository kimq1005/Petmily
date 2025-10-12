package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWritePeriodTextFieldComponent
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWritePeriodItem(
    modifier: Modifier = Modifier,
    startReceptionPeriod: String,
    endReceptionPeriod: String,
    onStartReceptionPeriod: (String) -> Unit,
    onEndReceptionPeriod: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.shelter_write_application_period_subtitle),
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
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            ShelterWritePeriodTextFieldComponent(
                modifier = Modifier
                    .weight(5f),
                value = startReceptionPeriod,
                hint = "25-10-01",
                onValue = {
                    onStartReceptionPeriod(it)
                }
            )

            ShelterWritePeriodTextFieldComponent(
                modifier = Modifier
                    .weight(5f),
                value = endReceptionPeriod,
                hint = "25-10-30",
                onValue = {
                    onEndReceptionPeriod(it)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWritePeriodItem() {
    ShelterWritePeriodItem(
        startReceptionPeriod = "",
        endReceptionPeriod = "",
        onStartReceptionPeriod = {},
        onEndReceptionPeriod = {}
    )
}