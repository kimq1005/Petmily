package com.llama.petmilly_client.presentation.shelterWrite.model

import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.presentation.home.model.PetCategoryType

@Immutable
data class ShelterWriteState(
    val petCategoryType: PetCategoryType =  PetCategoryType.ENTITY,
)