package com.llama.petmilly_client.presentation.home.model

import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.data.model.LibraryDTO.LibraryDetailDTO

@Immutable
data class HomeState(
    val petData: List<LibraryDetailDTO> = emptyList()
)