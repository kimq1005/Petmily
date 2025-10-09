package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteProfileTextFieldComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWriteCharmAppealSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    ShelterWriteCharmAppealScreen(
        charmAppeal = state.charmAppeal,
        onCharmAppeal = viewModel::setCharmAppeal,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteCharmAppealScreen(
    charmAppeal: String,
    onCharmAppeal: (String) -> Unit,
    onNavigate: () -> Unit,
) {
    val isCheck by remember(charmAppeal) {
        derivedStateOf { charmAppeal.isNotEmpty() }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_charm_appeal_title)
        )

        Text(
            text = stringResource(R.string.shelter_write_charm_appeal_text_field_title),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 28.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )
        )

        ShelterWriteProfileTextFieldComponent(
            modifier = Modifier
                .padding(top = 6.dp)
                .height(52.dp)
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            maxLines = 1,
            value = charmAppeal,
            onValue = {
                onCharmAppeal(charmAppeal)
            },
            hint = stringResource(R.string.shelter_write_charm_appeal_text_field_hint),
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            ButtonScreen(
                title = stringResource(R.string.next),
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (isCheck) Color.Black else Color.LightGray

            ) {
                if (isCheck) {
                    onNavigate()
                }
            }

            Text(
                text = "7/8", fontSize = 13.sp,
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
private fun PreviewShelterWriteCharmAppealScreen() {
    ShelterWriteCharmAppealScreen(
        charmAppeal = "",
        onCharmAppeal = {}, 
        onNavigate = {}
    )
}