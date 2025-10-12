package com.llama.petmilly_client.presentation.shelterWrite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.BottomBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterConditionTextFieldItem

@Composable
fun ShelterWriteConditionLastSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteConditionLastScreen(
        hopePeoples = state.hopePeoples,
        noPeoples = state.noPeoples,
        onHopePeoples = viewModel::setHopePeoples,
        onNoPeoples = viewModel::setNoPeoples,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteConditionLastScreen(
    hopePeoples: List<String>,
    noPeoples: List<String>,
    onHopePeoples: (String) -> Unit,
    onNoPeoples: (String) -> Unit,
    onNavigate: () -> Unit,
) {
    val isCheck by remember(hopePeoples, noPeoples) {
        derivedStateOf { hopePeoples.isNotEmpty() && noPeoples.isNotEmpty() }
    }

    var hopeValue by remember {
        mutableStateOf("")
    }

    var noValue by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_condition_title)
        )

        ShelterConditionTextFieldItem(
            modifier = Modifier
                .padding(top = 28.dp),
            title = stringResource(R.string.shelter_write_last_condition_text_field_first_title),
            hint = stringResource(R.string.shelter_write_last_condition_text_field_first_hint),
            value = hopeValue,
            onValue = { hopeValue = it },
            valueList = hopePeoples,
            onSetValue = onHopePeoples
        )

        ShelterConditionTextFieldItem(
            modifier = Modifier
                .padding(top = 20.dp),
            title = stringResource(R.string.shelter_write_last_condition_text_field_second_title),
            hint = stringResource(R.string.shelter_write_last_condition_text_field_second_hint),
            value = noValue,
            onValue = { noValue = it },
            valueList = noPeoples,
            onSetValue = onNoPeoples
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            page = "6/8",
            onClick = {
                if (isCheck) onNavigate()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteConditionLastScreen() {
    ShelterWriteConditionLastScreen(
        hopePeoples = listOf(),
        noPeoples = listOf(),
        onHopePeoples = {},
        onNoPeoples = {},
        onNavigate = {}
    )
}