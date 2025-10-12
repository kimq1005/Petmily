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
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWritePickUpCategoryItem
import com.llama.petmilly_client.presentation.shelterWrite.model.PickUpType

@Composable
fun ShelterWriteConditionSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteConditionScreen(
        pickUpType = state.pickUpType,
        tenancyCondition = state.tenancyCondition,
        onSetTenancyCondition = viewModel::setTemporaryCondition,
        onPickUpType = viewModel::setPickUpType,
        onNavigate = onNavigate
    )
}

@Composable
private fun ShelterWriteConditionScreen(
    pickUpType: PickUpType?,
    tenancyCondition: List<String>,
    onSetTenancyCondition: (String) -> Unit,
    onPickUpType: (PickUpType) -> Unit,
    onNavigate: () -> Unit,
) {
    val isCheck by remember(pickUpType) {
        derivedStateOf { pickUpType != null }
    }

    var value by remember {
        mutableStateOf("")
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_condition_title)
        )

        ShelterWritePickUpCategoryItem(
            modifier = Modifier
                .padding(top = 28.dp),
            pickUpType = pickUpType,
            onPickUpType = onPickUpType
        )

        ShelterConditionTextFieldItem(
            title = stringResource(R.string.shelter_write_condition_text_field_title),
            hint = stringResource(R.string.shelter_write_condition_text_field_hint),
            value = value,
            onValue = {
                value = it
            },
            valueList = tenancyCondition,
            onSetValue = onSetTenancyCondition
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            page = "5/8",
            onClick = {
                if (isCheck) onNavigate()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteConditionScreen() {
    ShelterWriteConditionScreen(
        pickUpType = PickUpType.DIRECT_PICKUP,
        tenancyCondition = listOf(),
        onSetTenancyCondition = {},
        onPickUpType = {},
        onNavigate = {}
    )
}