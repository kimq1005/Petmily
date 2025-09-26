package com.llama.petmilly_client.presentation.shelter.model

import androidx.compose.runtime.Immutable
import com.llama.petmilly_client.domain.model.shelter.PostDetail
import com.llama.petmilly_client.domain.model.shelter.TemporaryDetail

@Immutable
data class ShelterState(
    val postDataList: List<PostDetail> = listOf(
        PostDetail(
            id = 3871,
            name = "Minnie Pittman",
            age = 2.3,
            breed = "disputationi",
            gender = "impetus",
            inoculation = "quaeque",
            isComplete = false,
            isReceipt = false,
            neutered = "feugait",
            thumbnail = null,
            weight = 9167,
            createdAt = "senectus"
        )
    ),
    val selectedCategory: List<ShelterSafeCategoryType> = emptyList(),
    val temporaryDetail: TemporaryDetail? = null
)