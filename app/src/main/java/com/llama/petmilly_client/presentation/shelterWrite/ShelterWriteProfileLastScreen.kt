@file:Suppress("UNCHECKED_CAST")

package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.BottomBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteProfileTextFieldItem

@Composable
fun ShelterWriteProfileLastSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteProfileLastScreen(
        health = state.health,
        skill = state.skill,
        personality = state.personality,
        onHealth = viewModel::setHealth,
        onSkill = viewModel::setSkill,
        onPersonality = viewModel::setPersonality,
        onNavigate = onNavigate
    )
}

@Composable
fun ShelterWriteProfileLastScreen(
    health: String,
    skill: String,
    personality: String,
    onHealth: (String) -> Unit,
    onSkill: (String) -> Unit,
    onPersonality: (String) -> Unit,
    onNavigate: () -> Unit
) {
    val isCheck by remember(health, skill, personality) {
        derivedStateOf { health != "" && skill != "" && personality != "" }
    }

    Column(Modifier
        .fillMaxSize()
        .background(Color.White)
     ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_pet_profile_last_title)
        )

        ShelterWriteProfileTextFieldItem(
            modifier = Modifier
                .padding(top = 28.dp),
            health = health,
            skill = skill,
            personality = personality,
            onHealth = onHealth,
            onSkill = onSkill,
            onPersonality = onPersonality
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            page = "4/8",
            onClick = {
                if (isCheck) onNavigate()
            }
        )
    }
}

@Preview
@Composable
private fun PreviewShelterWriteProfileLastScreen() {
    ShelterWriteProfileLastScreen(
        health = "mandamus",
        skill = "tempus",
        personality = "natum",
        onHealth = {},
        onSkill = {},
        onPersonality = {},
        onNavigate = {}
    )
}