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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteProfileTextFieldComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.ui.theme.Grey_50_CBC4C4
import com.llama.petmilly_client.utils.ButtonScreen
import com.llama.petmilly_client.utils.UnKnownCheckBoxComponent
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@Composable
fun ShelterWriteProfileDetailInfoSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteProfileDetailInfoScreen(
        weight = state.weight,
        species = state.species,
        age = state.age,
        onAge = viewModel::setAge,
        onSpecies = viewModel::setSpecies,
        onWeight = viewModel::setWeight,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteProfileDetailInfoScreen(
    weight: String,
    species: String,
    age: String,
    onAge: (String) -> Unit,
    onSpecies: (String) -> Unit,
    onWeight: (String) -> Unit,
    onNavigate: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_pet_profile_title)
        )

        Text(
            text = stringResource(R.string.weight),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp, top = 28.dp),
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
                value = weight,
                onValue = onWeight,
                hint = stringResource(R.string.shelter_write_pet_profile_weight_hint),
                keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Text(
                text = " kg",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Text(
            text = stringResource(R.string.species),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        ShelterWriteProfileTextFieldComponent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp),
            value = species,
            onValue = onSpecies,
            hint = stringResource(R.string.shelter_write_pet_profile_species_hint),
            enable = species != stringResource(R.string.not_know)
        )

        Row(
            modifier = Modifier
                .padding(start = 27.dp, top = 10.dp)
        ) {
            UnKnownCheckBoxComponent(onclick = onSpecies)

            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = stringResource(R.string.not_know),
                fontSize = 12.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }

        Text(
            text = stringResource(R.string.age),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier.padding(start = 30.dp, top = 40.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .padding(horizontal = 26.dp)
        ) {
            ShelterWriteProfileTextFieldComponent(
                value = age,
                onValue = onAge,
                hint = stringResource(R.string.shelter_write_pet_profile_age_hint),
                enable = age != stringResource(R.string.not_know),
                keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Text(
                text = " 살 추정",
                modifier = Modifier.align(Alignment.CenterVertically),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 27.dp, top = 10.dp)
        ) {
            UnKnownCheckBoxComponent(onclick = onAge)

            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                text = stringResource(R.string.not_know),
                fontSize = 12.sp,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = Color(0xFF050505)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 20.dp)
        ) {
            val isCheck = weight != "" && age != "" && species != ""

            ButtonScreen(
                title = stringResource(R.string.next),
                textcolor = Color.White,
                fontSize = 15,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                backgroundcolor = if (isCheck) Color.Black else Color.LightGray

            ) {
                if (isCheck) onNavigate()
            }

            Text(
                text = "2/8", fontSize = 13.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                ),
                color = if (isCheck) Color.White else Grey_50_CBC4C4,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteProfileDetailInfoScreen() {
    ShelterWriteProfileDetailInfoScreen(
        weight = "1",
        species = "포메",
        age = "3",
        onAge = {},
        onSpecies = {},
        onWeight = {},
        onNavigate = {}
    )
}