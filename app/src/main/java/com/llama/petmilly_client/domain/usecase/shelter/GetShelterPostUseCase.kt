package com.llama.petmilly_client.domain.usecase.shelter

import com.llama.petmilly_client.domain.model.shelter.Post
import com.llama.petmilly_client.presentation.shelter.model.ShelterSafeCategoryType

interface GetShelterPostUseCase {
    suspend operator fun invoke(
        page: Int,
        limit: Int,
        cat: Boolean,
        dog: Boolean,
        isComplete: Boolean,
        weight: List<ShelterSafeCategoryType>,
        type: String,
    ): Result<Post>
}