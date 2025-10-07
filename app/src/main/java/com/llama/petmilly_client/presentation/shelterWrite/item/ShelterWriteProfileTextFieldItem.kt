package com.llama.petmilly_client.presentation.shelterWrite.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteProfileTextFieldComponent
import com.llama.petmilly_client.utils.notosans_bold

@Composable
fun ShelterWriteProfileTextFieldItem(
    modifier: Modifier = Modifier,
    health: String,
    skill: String,
    personality: String,
    onHealth: (String) -> Unit,
    onSkill: (String) -> Unit,
    onPersonality: (String) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        val items = listOf(
            arrayOf(
                stringResource(R.string.shelter_write_pet_profile_last_first_question_title),
                health,
                stringResource(R.string.shelter_write_pet_profile_last_first_question_hint)
            ),
            arrayOf(
                stringResource(R.string.shelter_write_pet_profile_last_second_question_title),
                skill,
                stringResource(R.string.shelter_write_pet_profile_last_second_question_hint)
            ),
            arrayOf(
                stringResource(R.string.shelter_write_pet_profile_last_third_question_title),
                personality,
                stringResource(R.string.shelter_write_pet_profile_last_third_question_hint)
            ),
        )

        items.forEachIndexed { i, (title, value, hint) ->
            val onValue = when (i) {
                0 -> onHealth
                1 -> onSkill
                else -> onPersonality
            }

            Text(
                text = title,
                color = Color.Black,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 30.dp, bottom = 6.dp),
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )

            ShelterWriteProfileTextFieldComponent(
                modifier = Modifier
                    .padding(bottom = 25.dp)
                    .height(80.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 26.dp),
                value = value,
                onValue = onValue,
                hint = hint,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteProfileTextFieldItem() {
    ShelterWriteProfileTextFieldItem(
        health = "",
        skill = "",
        personality = "소심",
        onHealth = {},
        onSkill = {},
        onPersonality = {}
    )
}