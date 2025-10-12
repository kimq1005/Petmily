package com.llama.petmilly_client.presentation.shelterWrite

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWritePeriodCautionItem
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWritePeriodItem

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShelterWriteApplicationPeriodSuccessScreen(
    viewModel: ShelterWriteViewModel,
) {
    val state = viewModel.container.stateFlow.collectAsState().value

    ShelterWriteApplicationPeriodScreen(
        startReceptionPeriod = state.startReceptionPeriod,
        endReceptionPeriod = state.endReceptionPeriod,
        onStartReceptionPeriod = viewModel::setStartReceptionPeriod,
        onEndReceptionPeriod = viewModel::setEndReceptionPeriod,
        onPost = {
            viewModel.postTemporaryProtection()
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun ShelterWriteApplicationPeriodScreen(
    startReceptionPeriod: String,
    endReceptionPeriod: String,
    onStartReceptionPeriod: (String) -> Unit,
    onEndReceptionPeriod: (String) -> Unit,
    onPost: () -> Unit,
) {
    val isCheck by remember(startReceptionPeriod, endReceptionPeriod) {
        derivedStateOf {
            startReceptionPeriod.isNotEmpty() && endReceptionPeriod.isNotEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_application_period_title)
        )

        ShelterWritePeriodItem(
            modifier = Modifier
                .padding(top = 28.dp),
            startReceptionPeriod = startReceptionPeriod,
            endReceptionPeriod = endReceptionPeriod,
            onStartReceptionPeriod = onStartReceptionPeriod,
            onEndReceptionPeriod = onEndReceptionPeriod,
        )

        ShelterWritePeriodCautionItem(
            modifier = Modifier
                .padding(top = 33.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.completed),
            isCheck = isCheck,
            onClick = {
                if (isCheck) onPost()
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
private fun PreviewShelterWriteApplicationPeriodScreen() {
    ShelterWriteApplicationPeriodScreen(
        startReceptionPeriod = "",
        endReceptionPeriod = "",
        onStartReceptionPeriod = {},
        onEndReceptionPeriod = {},
        onPost = {}
    )
}