package com.llama.petmilly_client.presentation.home.model

import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.domain.model.home.LibraryDetail

@Immutable
data class HomeState(
    val petData: List<LibraryDetail> = emptyList(),
    val selectedPetCategoryType: List<PetCategoryType> = emptyList(),
    val selectedShelterCategory: List<ShelterCategory> = emptyList(),
)