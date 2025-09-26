package com.llama.petmilly_client.presentation.shelter.model

import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail

@Immutable
data class ShelterDetailState(
    val temporaryDetail: TemporaryDetail? = null
)